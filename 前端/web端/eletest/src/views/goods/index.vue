<template>
  <div class="goods_container">
    <div class="title">
      <h1>商品管理</h1>
    </div>
    <div class="tool">
      <el-input v-model="q" class="input" placeholder="输入搜索内容" /><el-button type="primary" @click="handleSearch">搜索商品</el-button>
      <el-dropdown @command="handleCommand">
        <el-button type="primary">
          批量操作<i class="el-icon-arrow-down el-icon--right" />
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item icon="el-icon-delete" command="delete">删除选中</el-dropdown-item>
          <el-dropdown-item icon="el-icon-remove" command="cancel">取消选择</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
      <el-button type="primary" @click="handleAdd">添加商品</el-button>
    </div>
    <el-table
      ref="multipleTable"
      :data="tableData"
      border
      style="width: 100%"
      max-height="480"
      @selection-change="handleSelectionChange"
    >
      <el-table-column
        type="selection"
        width="45"
      />
      <el-table-column type="index" label="序号" width="50px" />
      <el-table-column prop="food_id" label="编号" />
      <el-table-column prop="food_name" label="名称" />
      <el-table-column prop="food_price" label="价格" sortable />
      <el-table-column prop="food_ingredient" label="原料" />
      <el-table-column
        prop="food_cat_name"
        label="分类"
        :filters="cates"
        :filter-method="catFilterHandler"
      />
      <el-table-column prop="food_commend" label="推荐" />
      <el-table-column prop="food_sales" label="销量" sortable />
      <el-table-column label="操作" width="150px">
        <template slot-scope="scope">
          <el-button type="primary" size="small" @click="handleEdit(scope)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDelete(scope)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-dialog title="警告" :visible.sync="dialogVisible" width="30%">
      <span>确认删除该商品</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="danger" @click="confimDelete">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog :visible.sync="dialogFormVisible" width="50%" @closed="dialogCloseEvent">
      <div slot="title" class="dialog-title">
        <h2 style="text-align: center;">{{ dialogTitle }}</h2>
      </div>
      <el-form :model="currentGoods" label-position="left" label-width="50px">
        <el-form-item label="名称">
          <el-input v-model="currentGoods.food_name" width="200px" />
        </el-form-item>
        <el-form-item label="价格">
          <el-input v-model="currentGoods.food_price" size="mini">
            <template slot="append">
              元
            </template>
          </el-input>
        </el-form-item>
        <el-form-item label="原料">
          <el-input v-model="currentGoods.food_ingredient" type="textarea" />
        </el-form-item>
        <el-form-item label="分类" class="classify">
          <el-select v-model="currentGoods.food_cat_name" placeholder="选择分类">
            <el-option v-for="(item, index) in cates" :key="index" :label="item.value" :value="item.value" />
          </el-select>
          <el-input
            v-show="iptVisible"
            v-model="newClassifyName"
            class="classify_ipt"
            placeholder="分类名称"
          />
          <el-button type="primary" class="add_btn" @click="handleAddClassify">{{ btnText }}</el-button>
        </el-form-item>
        <el-form-item label="推荐">
          <el-switch v-model="currentGoods.food_commend" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <el-button type="primary" @click="confirmChange">{{ dialogBtnText }}</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getGoods, updateGoodsInfo, deleteGoods, addGoods, searchGood } from '@/api/user'
import { mapGetters } from 'vuex'

export default {
  data() {
    return {
      tableData: [],
      dialogVisible: false,
      dialogFormVisible: false,
      initGoods: {
        food_name: '',
        food_price: '',
        food_ingredient: '',
        food_commend: 0,
        food_cat_name: ''
      },
      currentGoods: {

      }, // 当前操作所在行的信息
      dialogTitle: '',
      dialogBtnText: '',
      iptVisible: false, // 添加分类输入框显示、隐藏
      btnText: '添加分类',
      newClassifyName: '',
      cates: [], // 商品分类集合
      q: '',
      multipleSelection: [] // 选中的数据
    }
  },
  computed: {
    ...mapGetters(['id'])
  },
  created() {
    (async() => {
      // 获取商品数据
      const res = await getGoods(this.id)
      const { goods, cates } = res.data
      goods.forEach(item => {
        item.food_commend = item.food_commend ? '是' : '否'
      })
      this.tableData = goods
      this.cates = cates.map(item => {
        return { text: item, value: item }
      })
    })()
  },
  methods: {
    // 确认删除
    async confimDelete() {
      const { food_id, food_cat_name } = this.currentGoods
      const res = await deleteGoods({ food_id, food_cat_name })

      const type = res.errorCode === 0 ? 'success' : 'error'
      this.$message({
        message: res.message,
        type
      })

      if (res.errorCode === 0) {
        // eslint-disable-next-line eqeqeq
        const index = this.tableData.findIndex(item => item.food_id == food_id)
        this.tableData.splice(index, 1)
      }

      this.dialogVisible = false
    },

    handleDelete(scope) {
      this.currentGoods = scope.row
      this.dialogVisible = true
    },

    handleEdit(scope) {
      this.dialogTitle = '商品信息修改'
      this.dialogBtnText = '修改'
      this.currentGoods = JSON.parse(JSON.stringify(scope.row))
      this.currentGoods.food_commend = this.currentGoods.food_commend === '是'
      this.dialogFormVisible = true
    },

    // 点击编辑并确认修改、添加商品
    async confirmChange() {
      const flag = Object.keys(this.currentGoods).some(item => this.currentGoods[item] === '')

      if (flag) {
        return this.$message({
          message: '不能为空',
          type: 'warning'
        })
      }

      this.dialogFormVisible = false
      this.currentGoods.food_commend = this.currentGoods.food_commend ? 1 : 0

      let res

      if (this.dialogTitle === '商品添加') {
        // 处理商品添加
        res = await addGoods(this.currentGoods)

        if (res.errorCode === 0) {
          this.tableData = res.data
        }
      } else {
        // 处理修改商品信息
        res = await updateGoodsInfo(this.currentGoods)

        if (res.errorCode === 0) {
          const cloneGoods = JSON.parse(JSON.stringify(this.currentGoods))
          cloneGoods.food_commend =
          this.currentGoods.food_commend === 1 ? '是' : '否'
          const index = this.tableData.findIndex(
            // eslint-disable-next-line eqeqeq
            item => item.food_id == cloneGoods.food_id
          )
          this.tableData[index] = cloneGoods
        }
      }

      this.$message({
        message: res.message,
        type: 'success'
      })
    },
    // 添加商品
    handleAdd() {
      this.currentGoods = { ...this.initGoods }
      this.dialogTitle = '商品添加'
      this.dialogBtnText = '添加'
      this.dialogFormVisible = true
    },
    // 点击dialaog里的添加分类
    handleAddClassify() {
      if (this.iptVisible) {
        // 输入内容不为空
        if (this.newClassifyName !== '') {
          this.cates.unshift({ text: this.newClassifyName, value: this.newClassifyName })
          this.currentGoods['food_cat_name'] = this.newClassifyName
          this.$message({
            message: '添加成功',
            type: 'success'
          })
          this.btnText = '添加分类'
          this.iptVisible = false
        } else {
          this.$message({
            message: '请输入分类名称',
            type: 'warning'
          })
        }
      } else {
        this.btnText = '确认'
        this.iptVisible = true
      }
    },
    // 关闭dialog, 重置状态
    dialogCloseEvent() {
      this.btnText = '添加分类'
      this.iptVisible = false
    },
    catFilterHandler(value, row, column) {
      const property = column['property']
      return row[property] === value
    },
    async handleSearch() {
      if (this.q === '') return
      const result = await searchGood(this.q)
      this.tableData = result.data
    },
    // 批量操作
    handleCommand(command) {
      console.log(this.tableData)
      if (!this.multipleSelection.length) return

      if (command === 'delete') {
        this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          this.tableData = this.tableData.filter(item => {
            let exit = false
            this.multipleSelection.some(select => {
              exit = (item['_id'] === select['_id'])
              return exit
            })
            return !exit
          })
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          })
        })
      } else {
        this.$refs.multipleTable.clearSelection()
      }
    },
    // 选中状态改变
    handleSelectionChange(val) {
      this.multipleSelection = val
    }
  }
}
</script>

<style lang="scss">
.goods_container {
  margin: 10px 20px;
  padding: 10px 10px;
  background-color: #fff;

  .tool {
    display: flex;
    margin-bottom: 15px;

    .input {
      width: 15vw;
      margin-right: 15px;
    }
    .el-dropdown {
      margin: 0 10px;
    }
  }

  .title {
    text-align: center;
    h1 {
      margin-top: 10px;
      font-size: 28px;
    }
  }

  .cell {
    text-align: center;
  }

  .classify {
    .el-form-item__content {
      display: flex;

      .classify_ipt {
        width: 30%;
        margin-left: 30px;
      }

      .add_btn {
        margin-left: 15px;
      }
    }
  }
}
</style>
