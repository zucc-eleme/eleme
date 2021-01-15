<template>
  <div class="orders_container">
    <div class="title">
      <h1>订单管理</h1>
    </div>
    <div class="tool">
      <el-input v-model="q" class="input" placeholder="输入搜索内容">
        <el-select slot="append" v-model="select">
          <el-option label="订单号" value="订单号" default />
          <el-option label="买家姓名" value="买家姓名" />
        </el-select>
      </el-input>
      <el-button type="primary" @click="handleSearch">搜索订单</el-button>
    </div>
    <el-table
      :data="tableData"
      border
      :cell-style="{textAlign: 'center'}"
      :header-cell-style="{textAlign: 'center'}"
    >
      <el-table-column type="index" :index="computeIndex" label="序号" />
      <el-table-column prop="num" label="订单编号" />
      <el-table-column prop="userName" label="买家姓名" />
      <el-table-column prop="userPhone" label="买家手机号" />
      <el-table-column prop="time" label="下单时间" />
      <el-table-column prop="price" label="订单总价" />
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button type="primary" @click="handleLook(scope)">查看</el-button>
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
    <el-dialog title="订单详情" :visible.sync="dialogTableVisible">
      <el-table :data="currentLook" border>
        <el-table-column prop="id" label="商品编号" />
        <el-table-column prop="name" label="商品名称" />
        <el-table-column prop="num" label="数量" />
        <el-table-column prop="price" label="单价" />
        <el-table-column label="总价">
          <template slot-scope="scope">
            <span>{{ (scope.row.num * scope.row.price).toFixed(2) }}</span>
          </template>
        </el-table-column>
      </el-table>
    </el-dialog>
  </div>
</template>

<script>
import { getOrders, searchOrder } from '@/api/user'
import { mapGetters } from 'vuex'
import formatDate from '@/utils/formatDate'

export default {
  data() {
    return {
      tableData: [],
      currentLook: [], // 当前查看订单详情数据
      dialogTableVisible: false,
      total: 0, // 总数据数量
      page: 1, // 当前所在页数
      limit: 6, // 每页显示多少条数据
      select: '订单号', // 搜索分类
      q: '' // 搜索值
    }
  },
  computed: {
    ...mapGetters(['id']),
    computeIndex() {
      return (this.page - 1) * this.limit + 1
    }
  },
  created() {
    this.reqOrders()
  },
  methods: {
    reqOrders() {
      (async() => {
        const { id, page, limit } = this
        const res = await getOrders({
          id,
          page,
          limit
        })
        if (res.errorCode === 0) {
          const {
            data,
            pagination: { page, total }
          } = res
          data.forEach(item => {
            item.time = formatDate(item.time)
          })
          this.tableData = data
          this.page = page
          this.total = total
        }
      })()
    },
    handleLook(scope) {
      this.currentLook = scope.row.foods
      this.dialogTableVisible = true
    },
    changePageEvent() {
      this.reqOrders()
    },
    handleNext() {
      this.page += 1
    },
    handlePrev() {
      this.page -= 1
    },
    // 搜索订单
    async handleSearch() {
      const params = {}
      if (this.select === '订单号') {
        params['num'] = this.q
      } else {
        params['name'] = this.q
      }

      const result = await searchOrder(params)

      if (!result.data || !result.data.length) {
        this.$message({
          message: '搜索结果为空',
          type: 'success'
        })
      } else {
        this.tableData = result.data
      }
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
  .tool {
    display: flex;
    margin-bottom: 15px;

    .input {
      width: 20vw;
      margin-right: 15px;

      .el-input-group__append {
        width: 7vw;
      }
    }
    .el-dropdown {
      margin: 0 10px;
    }
  }
  .el-pagination {
    display: flex;
    justify-content: center;
    margin: 50px 0;
  }
}
</style>
