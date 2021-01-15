<template>
  <div :id="id" :class="className" :style="{height:height,width:width}" />
</template>

<script>
import echarts from 'echarts'
import resize from './mixins/resize'
export default {
  name: 'LineOrder',
  mixins: [resize],
  props: {
    className: {
      type: String,
      default: 'chart'
    },
    id: {
      type: String,
      default: 'chart'
    },
    width: {
      type: String,
      default: '200px'
    },
    height: {
      type: String,
      default: '200px'
    },
    lineData: {
      type: Object,
      default: () => ({})
    }
  },
  data() {
    return {
      chart: null
    }
  },
  watch: {
    lineData(newValue, oldValue) {
      this.initChart(this.lineData)
    }
  },
  beforeDestroy() {
    if (!this.chart) {
      return
    }
    this.chart.dispose()
    this.chart = null
  },
  methods: {
    initChart(lineData) {
      this.chart = echarts.init(document.getElementById(this.id))
      const options = {
        title: {
          text: '数据走势'
        },
        xAxis: {
          type: 'category',
          data: lineData.xData
        },
        yAxis: {
          type: 'value'
        },
        series: [
          {
            name: '周订单',
            data: lineData.weekOrderData,
            type: 'line',
            itemStyle: {
              normal: { label: { show: true }}
            },
            markPoint: {
              data: [
                { name: '最大值', type: 'max' },
                { name: '最小值', type: 'min' }
              ]
            }
          },
          {
            name: '总订单',
            data: lineData.weekTotalOrderData,
            type: 'line',
            itemStyle: {
              normal: { label: { show: true }}
            },
            markPoint: {
              data: [
                { name: '最大值', type: 'max' },
                { name: '最小值', type: 'min' }
              ]
            }
          },
          {
            name: '周浏览',
            data: lineData.weekVisitData,
            type: 'line',
            itemStyle: {
              normal: { label: { show: true }}
            },
            markPoint: {
              data: [
                { name: '最大值', type: 'max' },
                { name: '最小值', type: 'min' }
              ]
            }
          },
          {
            name: '总浏览',
            data: lineData.WeekTotalVisitData,
            type: 'line',
            itemStyle: {
              normal: { label: { show: true }}
            },
            markPoint: {
              data: [
                { name: '最大值', type: 'max' },
                { name: '最小值', type: 'min' }
              ]
            }
          }
        ],
        legend: {
          data: ['周订单', '总订单', '周浏览', '总浏览']
        },
        toolTip: {
          trigger: 'axis'
        },
        toolbox: {
          show: true,
          feature: {
            dataZoom: {
              yAxisIndex: 'none'
            },
            dataView: { readOnly: false },
            magicType: { type: ['line', 'bar'] },
            restore: {},
            saveAsImage: {}
          }
        }
      }
      this.chart.setOption(options)
    }
  }
}
</script>

<style>
</style>
