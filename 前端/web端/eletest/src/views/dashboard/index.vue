<template>
  <div class="dashboard-container">
    <section class="data_section">
      <div class="title">
        <h1>数据统计</h1>
      </div>
      <el-row>
        <el-col class="row_title today">当日数据</el-col>
        <el-col><span class="data">{{ lineData.dayOrderData * 2 }}</span><span class="text">新增会员</span></el-col>
        <el-col><span class="data">{{ lineData.dayOrderData }}</span><span class="text">新增订单</span></el-col>
        <el-col><span class="data">{{ lineData.dayVisitData }}</span><span class="text">新增浏览</span></el-col>
      </el-row>
      <el-row>
        <el-col class="row_title week">周数据</el-col>
        <el-col><span class="data">{{ lineData.newWeekOrderNum * 2 }}</span><span class="text">新增会员</span></el-col>
        <el-col><span class="data">{{ lineData.newWeekOrderNum }}</span><span class="text">新增订单</span></el-col>
        <el-col><span class="data">{{ lineData.newWeekTotalVisit }}</span><span class="text">新增浏览</span></el-col>
      </el-row>
      <el-row>
        <el-col class="row_title total">总数据</el-col>
        <el-col><span class="data">{{ lineData.totalOrderNum * 2 }}</span><span class="text">会员</span></el-col>
        <el-col><span class="data">{{ lineData.totalOrderNum }}</span><span class="text">订单</span></el-col>
        <el-col><span class="data">{{ lineData.totalVisitNum }}</span><span class="text">浏览</span></el-col>
      </el-row>
    </section>
    <section class="line_section">
      <LineOrder width="100%" height="100%" :line-data="lineData" />
    </section>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import LineOrder from '@/components/Charts/LineOrder.vue'
import { getChartOrderData } from '@/api/user.js'

export default {
  name: 'Dashboard',
  components: { LineOrder },
  data() {
    return {
      currentRole: 'adminDashboard',
      lineData: {
        newWeekOrderNum: 0,
        totalOrderNum: 0,
        dayOrderData: 0
      }
    }
  },
  computed: {
    ...mapGetters(['roles', 'id'])
  },
  async created() {
    if (!this.roles.includes('admin')) {
      this.currentRole = 'editorDashboard'
    }
    const result = await getChartOrderData(this.id)
    if (result.errorCode === 0) {
      this.lineData = result.data
    }
  }
}
</script>

<style scoped lang='scss'>
.dashboard-container {
  position: relative;
  width: 100%;
  height: calc(100vh - 84px);
  background-color: #fff;

  .data_section {
    padding: 10px 20px;
    margin: 10px 0 20px 0;

    .title {
      text-align: center;
      h1 {
        font-size: 28px;
        margin: 0;
      }
    }

    .el-row {
      display: flex;
      margin-top: 10px;

      .el-col {
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: 14px;
        color: #666;
        border-radius: 6px;
        background: #e5e9f2;

        &:not(:nth-of-type(4)) {
          margin-right: 10px;
        }

        .data {
          color: #333;
          font-size: 26px;
          padding-right: 5px;
        }
      }

      .row_title {
        border-radius: 6px;
        font-size: 22px;
        padding: 4px 0;
        color: #fff;

        &.today {
          background-color: #FF9800;
        }

        &.total {
          background-color: #20A0FF;
        }

        &.week {
          background-color: #42B983;
        }
      }
    }
  }
  .line_section {
    padding: 0 20px;
    height: 60vh;
  }
}
</style>
