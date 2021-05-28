<template>
  <div>
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item
          ><i class="el-icon-lx-calendar"></i> 电磁态势分析</el-breadcrumb-item
        >
        <el-breadcrumb-item>实体关系图</el-breadcrumb-item>
      </el-breadcrumb>
    </div>


    <div  class="container">

        <el-form>
            <el-form-item>
                <input type="text" ref="getValue" />
                <el-button type="primary"  @click="submitButton">搜索</el-button>
            </el-form-item>

        </el-form>

      <div style="height: calc(100vh - 50px)">
        <SeeksRelationGraph
          ref="seeksRelationGraph"
          :options="graphOptions"
          :on-node-click="onNodeClick"
          :on-line-click="onLineClick"
        />
      </div>
    </div>
  </div>
</template>


<script>
import SeeksRelationGraph from "relation-graph";
export default {
  name: "Demo",
  components: { SeeksRelationGraph },
  data() {
    return {
      isShowCodePanel: false,
      graphOptions: {
        defaultNodeBorderWidth: 0,
        defaultNodeColor: "rgba(122, 233, 94, 1)",
        allowSwitchLineShape: true,
        allowSwitchJunctionPoint: true,
        defaultLineShape: 1,
        layouts: [
          {
            label: "中心",
            layoutName: "center",
            layoutClassName: "seeks-layout-center",
          },
        ],
        defaultJunctionPoint: "border",
        // 这里可以参考"Graph 图谱"中的参数进行设置
      },
    };
  },
  mounted() {
    this.showSeeksGraph();
  },
  methods: {

      submitButton(){
          console.log(this.$refs.getValue.value)
      },
    showSeeksGraph(query) {
      var __graph_json_data = {
        rootId: "2",
        nodes: [
          { id: "辐射源", name: "辐射源", color: "#43a2f1" },
          { id: "雷达", name: "雷达", color: "#55a2f1" },
          { id: "活动规律", name: "活动规律", color: "#4393f1" },
          { id: "航母", name: "航母", color: "#43a212" },
          { id: "机场", name: "机场", color: "#4ff2f1" },
          { id: "战斗机", name: "战斗机", color: "#93a111" },
          { id: "地理信息", name: "地理信息", color: "#f3a211" },
          { id: "地形地物", name: "地形地物", color: "#423291" },
          { id: "高程位置", name: "高程位置", color: "#67943a" },
          { id: "港口", name: "港口", color: "#43ff40" },
          { id: "信号参数", name: "信号参数", color: "#fe32f9" },
          { id: "工作方式", name: "工作方式", color: "#4344f1" },
          { id: "驱逐舰", name: "驱逐舰", color: "#4222f1" },
          { id: "航迹航道", name: "航迹航道", color: "#482033" },
          { id: "载舰机", name: "载舰机", color: "#9882f1" },
        ],
        links: [
          { from: "辐射源", to: "雷达", text: "包含" },
          { from: "辐射源", to: "活动规律", text: "拥有" },
          { from: "航母", to: "辐射源", text: "装备" },
          { from: "机场", to: "辐射源", text: "装备" },
          { from: "战斗机", to: "辐射源", text: "装备" },
          { from: "战斗机", to: "机场", text: "停放" },
          { from: "战斗机", to: "地理信息", text: "位置" },
          { from: "地形地物", to: "地理信息", text: "属性" },
          { from: "高程位置", to: "地理信息", text: "属性" },
          { from: "港口", to: "辐射源", text: "装备" },
          { from: "航母", to: "港口", text: "航行" },
          { from: "驱逐舰", to: "港口", text: "停放" },
          { from: "信号参数", to: "雷达", text: "属性" },
          { from: "工作方式", to: "雷达", text: "属性" },
          { from: "活动规律", to: "航迹航道", text: "包含" },
          { from: "航母", to: "载舰机", text: "搭载" },
        ],
        // nodes: [
        //   { id: "2020年9月1日", name: "2020年9月1日", color: "#43a2f1" },
        //   { id: "-97.23", name: "-97.23", color: "#55a2f1" },
        //   { id: "2020年9月2日", name: "2020年9月2日", color: "#43a2f1" },
        //   { id: "-54.23", name: "-54.23", color: "#55a2f1" },
        //   { id: "2020年9月3日", name: "2020年9月3日", color: "#43a2f1" },{ id: "-18.23", name: "-18.23", color: "#55a2f1" },

        //   { id: "2020年9月4日", name: "2020年9月4日", color: "#43a2f1" },{ id: "-54.12", name: "-54.12", color: "#55a2f1" },
        //   { id: "2020年9月5日", name: "2020年9月5日", color: "#43a2f1" },{ id: "-19.25", name: "-19.25", color: "#55a2f1" },
        //   { id: "2020年9月6日", name: "2020年9月6日", color: "#43a2f1" },{ id: "-78.56", name: "-78.56", color: "#55a2f1" },
        //   { id: "2020年9月7日", name: "2020年9月7日", color: "#43a2f1" },{ id: "-37.35", name: "-37.35", color: "#55a2f1" },
        //   { id: "2020年9月8日", name: "2020年9月8日", color: "#43a2f1" },{ id: "-44.77", name: "-44.77", color: "#55a2f1" },
        //   { id: "2020年9月9日", name: "2020年9月9日", color: "#43a2f1" },{ id: "-38.42", name: "-38.42", color: "#55a2f1" },
        //   { id: "2020年9月10日", name: "2020年9月10日", color: "#43a2f1" },{ id: "-48.63", name: "-48.63", color: "#55a2f1" },
        // ],
        // links: [
        //   { from: "2020年9月1日", to: "-97.23", text: "频管中心幅度" },
        //   { from: "2020年9月2日", to: "-54.23", text: "频管中心幅度" },
        //   { from: "2020年9月3日", to: "-18.23", text: "频管中心幅度" },
        //   { from: "2020年9月4日", to: "-54.12", text: "频管中心幅度" },
        //   { from: "2020年9月5日", to: "-19.25", text: "频管中心幅度" },
        //   { from: "2020年9月6日", to: "-78.56", text: "频管中心幅度" },
        //   { from: "2020年9月7日", to: "-37.35", text: "频管中心幅度" },
        //   { from: "2020年9月8日", to: "-44.77", text: "频管中心幅度" },
        //   { from: "2020年9月9日", to: "-38.42", text: "频管中心幅度" },
        //   { from: "2020年9月10日", to: "-48.63", text: "频管中心幅度" },

        // ],
      };
      this.$refs.seeksRelationGraph.setJsonData(
        __graph_json_data,
        (seeksRGGraph) => {
          // 这些写上当图谱初始化完成后需要执行的代码
        }
      );
    },
    onNodeClick(nodeObject, $event) {
      console.log("onNodeClick:", nodeObject);
    },
    onLineClick(lineObject, $event) {
      console.log("onLineClick:", lineObject);
    },
  },
};
</script>

<style lang="scss">
</style>

<style lang="scss" scoped>
</style>
