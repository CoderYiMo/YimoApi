<template>
  <PrismEditor class="my-editor" v-model="code" :highlight="highlighter" line-numbers readonly></PrismEditor>
</template>

<script>
// import highlighting library (you can use any library you want just return html string)
import { highlight, languages } from 'prismjs/components/prism-core';
import 'prismjs/components/prism-clike';
import 'prismjs/components/prism-javascript';
import 'prismjs/themes/prism-tomorrow.css';
import {PrismEditor} from "vue-prism-editor";

export default {
  components: {
    PrismEditor,
  },
  data: () => ({ code: '' }),
  methods: {
    highlighter(code) {
      this.code = this.codeText
      return highlight(code, languages.js); // languages.<insert language> to return html with markup
    },
  },
  props:['codeText']
};
</script>

<style>
/* required class */
.my-editor {
  /* we dont use `language-` classes anymore so thats why we need to add background and text color manually */
  background: #2d2d2d;;
  color: #ccc;

  /* you must provide font-family font-size line-height. Example: */
  font-family: Fira code, Fira Mono, Consolas, Menlo, Courier, monospace;
  font-size: 14px;
  line-height: 1.5;
  padding: 5px;
}

/* optional class for removing the outline */
.prism-editor__textarea:focus {
  outline: none;
}
</style>