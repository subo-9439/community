<template>
  <h1>테스트1</h1>
  <h1
    v-bind="str"
    @click="apply">
    안녕
    {{ str }}
  </h1>
  <text>
    {{ str }}
    str
  </text>
  <h3 v-bind="str">
    {{ comp }}
  </h3> 
</template>

<script>
import UserService from '../services/user.services';

export default {
    data() {
        return {
            str: '',
            comp: ''
        };
    },
    mounted() {
        UserService.getHello().then(
            (res)=>{
                console.log(res.data);
                this.comp = res.data;
        },
        (error) => {
            this.str =
            (error.res && 
            error.res.data &&
            error.res.data.message) ||
            error.message ||
            error.toString();
        }
        );
    },
};
</script>
// ,    
//     props: {
//     },
//     computed : {
//     },
//     methods : {
//         apply() {
//             // this.$store.commit('test/assignStr')
//             this.$store.dispatch('test/getStr',{
//                 str: this.str,
//             })

//         },
//         sout() {
//             console.log("sout"+this.$store.state.str)
//             this.$store.state.str;
//         }
//     }