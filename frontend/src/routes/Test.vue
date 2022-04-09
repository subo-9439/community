<template>
  <h1>테스트1</h1>
  <h1
    v-bind="str"
    @click="apply">
    안녕
    {{ str }}
  </h1>
  <text @click="sout">
    {{ str }}
    str
  </text>
</template>

<script>

export default {
    data() {
        return {
            str: ''
        }
    },
    props: {
    },
    computed : {
    },
    methods : {
        apply() {
            // this.$store.commit('test/assignStr')
            this.$store.dispatch('test/getStr',{
                str: this.str,
            })

        },
        sout() {
            console.log("sout"+this.$store.state.str)
            this.$store.state.str;
        }
    }
}
</script>