<template>
  <GlobalFooter :links="links" :copyright="copyright" />
</template>

<script>
export default {
  name: "MyFooter",
  data () {
    return {
      links: [
        {
          key: '帮助',
          title: '帮助',
          href: 'https://www.iviewui.com',
          blankTarget: true
        },
        {
          key: 'github',
          icon: 'logo-github',
          href: 'https://github.com/view-design/ViewUIPlus',
          blankTarget: true
        },
        {
          key: '条款',
          title: '条款',
          href: '',
          blankTarget: true
        }
      ],
      copyright: 'Copyright © 2023 YiMo All Rights Reserved'
    }
  }
}
</script>

<style scoped>

</style>