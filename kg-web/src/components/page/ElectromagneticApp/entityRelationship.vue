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

    <div>
      <div style="height: calc(100vh - 50px)">
        <SeeksRelationGraph
          ref="seeksRelationGraph"
          :options="graphOptions"
          :on-node-click="onNodeClick"
          :on-line-click="onLineClick"
        />
      </div>
      <el-button type="success" class="c-show-code-button"
        ><el-link
          href="https://github.com/seeksdream/relation-graph/blob/master/doc/demo/Demo4LayoutCenter.vue"
          target="_blank"
          style="color: #ffffff"
          >查看代码</el-link
        ></el-button
      >
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