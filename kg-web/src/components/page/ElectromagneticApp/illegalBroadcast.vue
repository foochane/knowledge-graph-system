<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item
          ><i class="el-icon-date"></i>电磁态势分析</el-breadcrumb-item
        >
        <el-breadcrumb-item>黑广播识别</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="schart">
      <div class="content-title">广播非法词统计</div>
      <!-- 柱状图 -->
      <div id="myChart1" :style="{ width: '650px', height: '600px' }"></div>
    </div>

    <div class="schart">
      <div class="content-title">黑广播聚类</div>
      <!-- 散点图 -->
      <div id="myChart2" :style="{ width: '600px', height: '600px' }"></div>
    </div>
  </div>
</template>

<script>
import ecStat from "echarts-stat";
import * as echarts from "echarts";
export default {
  mounted() {
    this.drawLine1();
    this.drawLine2();
  },
  methods: {
    drawLine1() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById("myChart1"));
      // 绘制图表
      myChart.setOption({
        title: { text: "" },
        color: ["#3398DB"],
        tooltip: {},
        xAxis: {
          data: [
            "广播1",
            "广播2",
            "广播3",
            "广播4",
            "广播5",
            "广播6",
            "广播7",
            "广播8",
            "广播9",
            "广播10",
          ],
          name: "广播",
          nameLocation: "middle",
          nameTextStyle: {
            fontStyle: "normal",
            fontWeight: "bold",
            fontSize: 13,
            align: "center",
            lineHeight: 30,
          },
        },
        yAxis: {
          type: "value",
          show: true,
          position: "left",
          name: "非法词数量",
          nameLocation: "middle",
          nameTextStyle: {
            fontWeight: "bold",
            lineHeight: 49,
            fontSize: 13,
          },
        },
        series: [
          {
            name: "非法词数量",
            type: "bar",
            data: [34, 20, 4, 24, 1, 16, 36, 2, 19, 20],
          },
        ],
      });
    },

    drawLine2() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById("myChart2"));
      echarts.registerTransform(ecStat.transform.clustering);
      var data = [
        [2.1889, 2.45454],
        [-3.344465, 2.603513],
        [0.355083, -2.376585],
        [2.682252, 4.007573],
        [-3.087776, 2.878713],
        [0.639276, -3.41284],
        [-1.226597, -3.317889],
        [1.148946, 3.345138],
        [-2.113864, 3.548172],
        [1.845762, 2.589788],
      ];
      var CLUSTER_COUNT = 10;
      var DIENSIION_CLUSTER_INDEX = 2;
      var COLOR_ALL = [
        "#37A2DA",
        "#e06343",
        "#37a354",
        "#b55dba",
        "#b5bd48",
        "#8378EA",
        "#F6BF1F",
        "#5681FF",
        "#2314FF",
        "#FF1278",
      ];
      var pieces = [];
      for (var i = 0; i < CLUSTER_COUNT; i++) {
        pieces.push({
          value: i,
          label: "广播 " + (i + 1),
          color: COLOR_ALL[i],
        });
      }

      console.log(pieces)
      // 绘制图表
      myChart.setOption({
        dataset: [
          {
            source: data,
          },
          {
            transform: {
              type: "ecStat:clustering",
              print: true,
              config: {
                clusterCount: CLUSTER_COUNT,
                outputType: "single",
                outputClusterIndexDimension: DIENSIION_CLUSTER_INDEX,
              },
            },
          },
        ],
        tooltip: {
          position: "top",
        },
        visualMap: {
          type: "piecewise",
          top: "middle",
          min: 0,
          max: CLUSTER_COUNT,
          left: 10,
          splitNumber: CLUSTER_COUNT,
          dimension: DIENSIION_CLUSTER_INDEX,
          pieces: pieces,
        },
        grid: {
          left: 120,
        },
        xAxis: {
          name:
            "出现频率低                                                                                            出现频率高",
          nameLocation: "middle",
          nameTextStyle: {
            fontStyle: "normal",
            fontWeight: "bold",
            fontSize: 13,
            align: "center",
            lineHeight: -400,
          },
          axisLabel: {
            show: false,
          },
        },
        yAxis: {
          name:
            "合法                                                                                                               非法",
          nameLocation: "middle",
          nameTextStyle: {
            fontStyle: "normal",
            fontWeight: "bold",
            fontSize: 13,
            align: "center",
            lineHeight: -480,
          },
          axisLabel: {
            show: false,
          },
        },
        series: {
          type: "scatter",
          encode: { tooltip: [0, 1] },
          symbolSize: 15,
          itemStyle: {
            borderColor: "#555",
          },
          datasetIndex: 1,
        },
      });
    },
  },
};
</script>

<style scoped>
.schart {
  width: 600px;
  display: inline-block;
}
.content-title {
  clear: both;
  font-weight: 400;
  line-height: 50px;
  margin: 10px 0;
  font-size: 22px;
  color: #1f2f3d;
}
</style>