<template>
  <div class="orders_container">
    <div class="title">
      <h1>库存管理</h1>
    </div>
    <el-table
      :data="tableData"
      border
      :cell-style="{textAlign: 'center'}"
      :header-cell-style="{textAlign: 'center'}"
    >
      <el-table-column
        type="selection"
        width="45"
      />
      <el-table-column type="index" :index="computeIndex" label="序号" width="50px" />
      <el-table-column prop="num" label="编号" />
      <el-table-column prop="type" label="类型" />
      <el-table-column prop="name" label="名称" />
      <el-table-column prop="storage" label="库存量" />
      <el-table-column prop="unit" label="单位" />
      <el-table-column prop="time" label="最近修改" />
      <el-table-column prop="roleName" label="操作人" />
      <el-table-column label="操作" width="150px">
        <template slot-scope="scope">
          <el-button type="primary" size="small" @click="handleEdit(scope)">编辑</el-button>
          <el-button type="danger" size="small" @click="handleDelete(scope)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      :total="total"
      :current-page.sync="page"
      :page-size="limit"
      background
      layout="total, prev, pager, next"
      @next-click="handleNext"
      @prev-click="handlePrev"
      @current-change="changePageEvent"
    />
    <el-dialog title="信息编辑" :visible.sync="dialogFormVisible">
      <el-form :model="currentEdit">
        <el-form-item label="编号" :label-width="formLabelWidth">
          <el-input v-model="currentEdit.num" disabled />
        </el-form-item>
        <el-form-item label="类型" :label-width="formLabelWidth">
          <el-input v-model="currentEdit.type" autocomplete="off" />
        </el-form-item>
        <el-form-item label="名称" :label-width="formLabelWidth">
          <el-input v-model="currentEdit.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="库存量" :label-width="formLabelWidth">
          <el-input v-model="currentEdit.storage" autocomplete="off" />
        </el-form-item>
        <el-form-item label="单位" :label-width="formLabelWidth">
          <el-input v-model="currentEdit.unit" autocomplete="off" />
        </el-form-item>
        <el-form-item label="最近修改" :label-width="formLabelWidth">
          <el-input v-model="currentEdit.time" disabled />
        </el-form-item>
        <el-form-item label="操作人" :label-width="formLabelWidth">
          <el-input v-model="currentEdit.roleName" disabled />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="handleConfirm(currentEdit.index)">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      tableData: [
        {
          num: 10001,
          type: '食材',
          name: '萝卜',
          storage: '118',
          unit: '斤',
          time: '2018-08-02',
          roleName: '经理'
        },
        {
          num: 10002,
          type: '食材',
          name: '鸡',
          storage: '10',
          unit: '只',
          time: '2019-08-02',
          roleName: '小明'
        },
        {
          num: 10003,
          type: '食材',
          name: '鱼',
          storage: '11',
          unit: '条',
          time: '2020-01-02',
          roleName: '王强'
        },
        {
          num: 10004,
          type: '食材',
          name: '鸭',
          storage: '18',
          unit: '只',
          time: '2020-01-06',
          roleName: '王强'
        },
        {
          num: 10005,
          type: '用具',
          name: '桌子',
          storage: '33',
          unit: '张',
          time: '2018-08-02',
          roleName: '王强'
        },
        {
          num: 10006,
          type: '用具',
          name: '凳子',
          storage: '188',
          unit: '把',
          time: '2018-08-02',
          roleName: '王强'
        },
        {
          num: 10006,
          type: '食材',
          name: '洋葱',
          storage: '8',
          unit: '斤',
          time: '2019-06-22',
          roleName: '经理'
        },
        {
          num: 10007,
          type: '清洗用品',
          name: '洗洁精',
          storage: '18',
          unit: '瓶',
          time: '2018-08-02',
          roleName: '经理'
        },
        {
          num: 10008,
          type: '清洗用品',
          name: '消毒水',
          storage: '66',
          unit: '瓶',
          time: '2018-09-16',
          roleName: '经理'
        }
      ],
      currentEdit: {
        name: '',
        sex: '',
        num: '',
        position: '',
        salary: '',
        remark: '',
        index: 0
      }, // 当前查看订单详情数据
      currentEditIndex: 0,
      dialogFormVisible: false,
      total: 118, // 总数据数量
      page: 1, // 当前所在页数
      limit: 6, // 每页显示多少条数据,
      formLabelWidth: '75px'
    }
  },
  computed: {
    computeIndex() {
      return (this.page - 1) * this.limit + 1
    }
  },
  created() {
    // this.total = this.tableData.length
  },
  methods: {
    changePageEvent() {},
    handleEdit(scope) {
      this.currentEdit = { ...scope.row }
      this.currentEditIndex = scope.$index
      this.dialogFormVisible = true
    },
    handleDelete(scope) {
      this.$confirm('确认删除？', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      })
        .then(() => {
          // 点击确认
          this.tableData.splice(scope.$index, 1)
          this.$message({
            message: '删除成功',
            type: 'success'
          })
        })
        .catch(e => {
          // 点击取消
        })
    },
    handleNext() {},
    handlePrev() {},
    handleConfirm(index) {
      this.tableData[this.currentEditIndex] = this.currentEdit
      this.dialogFormVisible = false
    }
  }
}
</script>

<style lang="scss">
.orders_container {
  margin: 10px 10px;
  padding: 5px 10px;
  background-color: #fff;

  .title {
    h1 {
      text-align: center;
      font-size: 28px;
    }
  }
  .el-pagination {
    display: flex;
    justify-content: center;
    margin: 50px 0;
  }
}
</style>
