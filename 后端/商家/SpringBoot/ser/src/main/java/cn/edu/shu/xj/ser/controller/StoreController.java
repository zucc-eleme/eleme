package cn.edu.shu.xj.ser.controller;

import cn.edu.shu.xj.ser.SerApplication;
import cn.edu.shu.xj.ser.config.Md5Utils;
import cn.edu.shu.xj.ser.entity.Goods;
import cn.edu.shu.xj.ser.entity.GoodsEvaluation;
import cn.edu.shu.xj.ser.entity.Ord;
import cn.edu.shu.xj.ser.entity.Store;
import cn.edu.shu.xj.ser.service.IGoodsEvaluationService;
import cn.edu.shu.xj.ser.service.IOrdService;
import cn.edu.shu.xj.ser.service.IStoreService;
import cn.edu.shu.xj.ser.service.impl.GoodsEvaluationService;
import cn.edu.shu.xj.ser.service.impl.StoreService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;

@Api(tags = "测试接口")
@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    IStoreService storeService;
    IOrdService ordService;
    IGoodsEvaluationService goodsEvaluationService;

    @ApiOperation(value = "商家注册")
    @PostMapping("/register")
    public String register(@RequestBody Store store){
        Store isStore=storeService.findOneStore(store.getStorePhone());
        if(isStore!=null) return "该手机号已被注册";
        String password = Md5Utils.code(store.getStorePasswd());//密码加密
        store.setStorePasswd(password);
        if(storeService.saveOrUpdate(store)) return "注册成功";
        return "注册失败";
    }

    @ApiOperation(value = "商家修改信息")
    @PostMapping("/save/info")
    public String save(@RequestBody Store store){
        SerApplication.mystore=store;
        if(storeService.saveOrUpdate(store)) return "修改成功";
        return "修改失败";
    }

    @ApiOperation(value = "商家修改密码")
    @PostMapping("/save/passwd")
    public String save(@RequestParam String passwd1,@RequestParam String passwd2){
        passwd1=Md5Utils.code(passwd1);
        if(!SerApplication.mystore.getStorePasswd().equals(passwd1)) return "原密码错误";
        passwd2=Md5Utils.code(passwd2);
        SerApplication.mystore.setStorePasswd(passwd2);
        if(storeService.saveOrUpdate(SerApplication.mystore)) return "密码修改成功";
        return "密码修改失败";
    }
    

    @ApiOperation(value = "删除商家")
    @PostMapping("/delete/by/id")
    public String remove(@RequestParam long id){
        if(storeService.removeById(id)) return "删除成功";
        return "删除失败";
    }

    @ApiOperation(value = "商家登录")
    @GetMapping("/login")
    public String login(String phone,String passwd){
        Store store=storeService.findOneStore(phone);
        passwd=Md5Utils.code(passwd);
        //System.out.println(store);
        if(store==null) return "手机号未被注册";
        if(!store.getStorePasswd().equals(passwd)) return "密码错误";
        SerApplication.mystore=store;
        return "登陆成功";
    }

    @ApiOperation(value = "商家评分")
    @GetMapping("/storeRating")
    public float storesRating(Store store){
        LambdaQueryWrapper<GoodsEvaluation> qw=new QueryWrapper<GoodsEvaluation>().lambda().like(GoodsEvaluation::getStoreId,store.getStoreId());
        List<GoodsEvaluation> evaluations= goodsEvaluationService.list(qw);
        int n=goodsEvaluationService.count(qw);
        if(n==0) return 0;
        float sum=0;
        for(GoodsEvaluation goodsEvaluation:evaluations){
            sum+=goodsEvaluation.getEvaluationStar();
        }
        return sum/n;
    }

    @ApiOperation(value = "人平均消费")
    @GetMapping("/aveConsumption")
    public float averageConsumption(Store store){
        LambdaQueryWrapper<Ord> qw=new QueryWrapper<Ord>().lambda().like(Ord::getStoreId,store.getStoreId());
        List<Ord> ords= ordService.list(qw);
        int n=0;
        float sum=0;
        for(Ord ord:ords){
            if(ord.getIsReturn()==2){
                n++;
                sum+=ord.getTotalMoney();
            }
        }
        if(n==0) return 0;
        return sum/n;
    }

    @ApiOperation(value = "根据类别显示商家")
    @GetMapping("/storeClass")
    public List<Store> storesByClass(String storeClass){
        LambdaQueryWrapper<Store> qw=new QueryWrapper<Store>().lambda().like(Store::getStoreClass,storeClass);
        return storeService.list(qw);
    }

    @ApiOperation(value = "根据商品名显示商家")
    @GetMapping("/goodsName")
    public List<Store> storesByGoods(String goodsName){
        return storeService.storesByGoods(goodsName);
    }

    @ApiOperation(value = "根据商家名显示商家")
    @GetMapping("/storeName")
    public List<Store> storesByName(String storeName){
        LambdaQueryWrapper<Store> qw=new QueryWrapper<Store>().lambda().like(Store::getStoreName,storeName);
        return storeService.list(qw);
    }

    @ApiOperation(value = "显示所有商家")
    @GetMapping("/allStore")
    public List<Store> allStores(){
        return storeService.allStores();
    }

    @ApiOperation(value = "按(月）销量从高到低排序")
    @GetMapping("/sortByVolume")
    public List<Store> sortByVolume(List<Store> stores){
        List<Integer> volumes=new ArrayList<>();
        for(Store store: stores){
            int count=ordService.saveVolumeBeforeTime(30,store.getStoreId());
            volumes.add(count);
        }
        Collections.sort(stores,new Comparator<Store>(){
            @Override
            public int compare(Store o1, Store o2) {
                int t1=stores.indexOf(o1);
                int t2=stores.indexOf(o2);
                if(volumes.get(t1)>volumes.get(t2)) return -1;
                else if(volumes.get(t1)==volumes.get(t2)) return 0;
                else return 1;
            }
        });
        return stores;
    }

    @ApiOperation(value = "按好评从高到低排序")
    @GetMapping("/sortByRating")
    public List<Store> sortByRates(List<Store> stores){
        Collections.sort(stores,new Comparator<Store>(){
            @Override
            public int compare(Store o1, Store o2) {
                float rate1=storesRating(o1);
                float rate2=storesRating(o2);
                if(rate1>rate2) return -1;
                else if(rate1==rate2) return 0;
                else return 1;
            }
        });
        return stores;
    }

    @ApiOperation(value = "按人均消费从高到低排序")
    @GetMapping("/sortByConsumption")
    public List<Store> sortByConsumption(List<Store> stores){
        Collections.sort(stores,new Comparator<Store>(){
            @Override
            public int compare(Store o1, Store o2) {
                float com1=averageConsumption(o1);
                float com2=averageConsumption(o2);
                if(com1>com2) return -1;
                else if(com1==com2) return 0;
                else return 1;
            }
        });
        return stores;
    }
}
