<template>
    <v-dialog v-model="dialog" class="relative" persistent max-width="800">
        <v-card class="relative add-content">
        <v-btn
            fab
            small
            class="dms-top-right-x link-feel"
            @click.prevent="closeModal">
            <v-icon>close</v-icon>
        </v-btn>
        <form>
            <v-layout row justify-center>
            <v-flex md10>
                <h2>Create new subject</h2>
            </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-text-field
                    name="name"
                    v-model="subject.name"
                    label="Name"
                    required
                    ></v-text-field>
                </v-flex>
            </v-layout>

            <v-layout row justify-center>
                <v-flex md10>
                    <v-text-field
                    name="description"
                    v-model="subject.description"
                    label="Description"
                    required
                    ></v-text-field>
                </v-flex>
            </v-layout>
            

            <v-layout row justify-center>
                <v-flex md10>
                    <v-btn color="primary" @click="save">Save</v-btn>
                </v-flex>
            </v-layout>
            <v-layout row justify-center>
                <v-flex md10>
                    <v-alert
                    :value="showError"
                    type="error"
                    >
                        {{ errorMessage }}
                    </v-alert>
                </v-flex>
            </v-layout>
        </form>
        </v-card>
    </v-dialog>
</template>

<script>
export default {
  data() {
    return {
      dialog: true,
      subject: {
        name: "",
        description: ""
      },
      showError: false,
      errorMessage: ""
    };
  },
  methods: {
    closeModal() {
      this.dialog = false;
      this.$emit("close");
    },
    save() {
      this.$store
        .dispatch("subjects/createSubject", this.subject)
        .then(response => {
          this.$emit("close");
        })
        .catch(error => {
          this.showError = true;
          this.errorMessage = error.response.data.message;
        });
    }
  }
};
</script>
