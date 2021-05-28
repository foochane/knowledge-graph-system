<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item
          ><i class="el-icon-date"></i>态势分析</el-breadcrumb-item
        >
        <el-breadcrumb-item>频谱信息预测</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="schart">
      <div class="content-title">频谱时序预测1</div>
      <div id="myChart1" :style="{ width: '600px', height: '380px' }"></div>
    </div>

    <div class="schart">
      <div class="content-title">频谱时序预测2</div>
      <div id="myChart2" :style="{ width: '600px', height: '380px' }"></div>
    </div>

      <div class="schart">
          <div class="content-title">频谱时序预测3</div>
          <div id="myChart3" :style="{ width: '600px', height: '380px' }"></div>
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
    this.drawLine3();
  },
  methods: {
    drawLine1() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById("myChart1"));
      echarts.registerTransform(ecStat.transform.clustering);
        const url = '/static/predict1.json';
        // const url = '/api/electromagnetic/predict';
        this.$axios.get(url, {page: this.cur_page}).then((res) => {
          console.log(res.data);
          myChart.setOption(res.data);

      });
    },


    drawLine2() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = echarts.init(document.getElementById("myChart2"));

        const url = '/static/predict2.json';
        // const url = '/api/electromagnetic/predict';
        this.$axios.get(url, {page: this.cur_page}).then((res) => {
            console.log(res.data);
            myChart.setOption(res.data);

      });
    },
      drawLine3() {
          // 基于准备好的dom，初始化echarts实例
          var myChart = echarts.init(document.getElementById("myChart3"));

          const url = '/static/predict3.json';
          // const url = '/api/electromagnetic/predict';
          this.$axios.get(url, {page: this.cur_page}).then((res) => {
              console.log(res.data);
              myChart.setOption(res.data);

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
