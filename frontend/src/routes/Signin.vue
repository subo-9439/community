<template>
  <body class="text-center">
    <main class="form-signin">
      <form>
        <img
          class="mb-4"
          alt=""
          width="72"
          src="~assets/logo.png"
          height="57" />
        <h1 class="h3 mb-3 fw-normal">
          Please sign in
        </h1>

        <div class="form-floating">
          <input
            type="email"
            class="form-control"
            id="floatingInput"
            placeholder="name@example.com" />
          <label for="floatingInput">Email address</label>
        </div>
        <div class="form-floating">
          <input
            type="password"
            class="form-control"
            id="floatingPassword"
            placeholder="Password" />
          <label for="floatingPassword">Password</label>
        </div>

        <div class="checkbox mb-3">
          <label>
            <input
              type="checkbox"
              value="remember-me" /> Remember me
          </label>
        </div>
        <button
          class="w-100 btn btn-lg btn-primary"
          type="submit">
          Sign in
        </button>
        <p class="mt-5 mb-3 text-muted">
          &copy; 2017–2021
        </p>
      </form>
    </main>
  </body>
</template>

<script>
import { Form, Field, ErrorMessage } from "vee-validate";
import * as yup from "yup";

export default {
  name: "Login",
  components: {
    Form,
    Field,
    ErrorMessage,
  },
  data() {
    const schema = yup.object().shape({
      username: yup.string().required("Username is required!"),
      password: yup.string().required("Password is required!"),
    });

    return {
      loading: false,
      message: "",
      schema,
    };
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created() {
    if (this.loggedIn) {
      this.$router.push("/profile");
    }
  },
  methods: {
    handleLogin(user) {
      this.loading = true;

      this.$store.dispatch("auth/login", user).then(
        () => {
          this.$router.push("/profile");
        },
        (error) => {
          this.loading = false;
          this.message =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();
        }
      );
    },
  },
};
</script>

<style lang="scss" scoped>
.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

html {
  height: 100%;
}

body {
  height: 100%;
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;

  .checkbox {
    font-weight: 400;
  }

  .form-floating:focus-within {
    z-index: 2;
  }

  input {
    &[type="email"] {
      margin-bottom: -1px;
      border-bottom-right-radius: 0;
      border-bottom-left-radius: 0;
    }

    &[type="password"] {
      margin-bottom: 10px;
      border-top-left-radius: 0;
      border-top-right-radius: 0;
    }
  }
}
</style>