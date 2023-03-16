<template>
  <div class="title">免费接口</div>
  <Divider class="divider"/>
  <div class="search">
    <Input search placeholder="请输入关键词" />
  </div>
  <div class="list">
    <List>
      <ListItem>
        <ListItemMeta avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar" title="This is title" description="This is description, this is description." />
      </ListItem>
      <ListItem>
        <ListItemMeta avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar" title="This is title" description="This is description, this is description." />
      </ListItem>
      <ListItem>
        <ListItemMeta avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar" title="This is title" description="This is description, this is description." />
        <template #action>
          <li>
            <a href="">Edit</a>
          </li>
          <li>
            <a href="">More</a>
          </li>
        </template>
      </ListItem>
      <ListItem>
        <ListItemMeta avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar" title="This is title" description="This is description, this is description." />
        <template #action>
          <li>
            <a href="">Edit</a>
          </li>
          <li>
            <a href="">More</a>
          </li>
        </template>
      </ListItem>
    </List>
  </div>
  <div class="page">
    <Page :total="100" show-elevator />
  </div>
  <div class="updateTime">
    <div class="t1">上次更新：</div>
    <div class="t2">2023/02/20,15:32:09</div>
  </div>
  <Divider plain>THE END</Divider>
  <MyFooter></MyFooter>
</template>

<script>
import MyFooter from "./MyFooter.vue";

export default {
  name: "Interface",
  components: {MyFooter}
}
</script>

<style scoped lang="less">
.updateTime{
  display: flex;
  justify-content: right;
  margin-top: 20px;
.t1{
  color: #336673;
}
.t2{
  color: #aaa;
}
}
.title{
  //border: 1px solid #000;
  color: #004050;
  font-size: 22px;
}
.divider{
  //border: 1px solid #000;
  margin: 4px 0;
}
.search{
  margin-top: 10px;
}
.list{
  margin-top: 10px;
}
.page{
  margin-top: 10px;
}
</style>