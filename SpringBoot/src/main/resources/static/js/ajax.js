
<!--Create-->

function getCreate() {

        Swal.fire({
            position: 'top-end',
            icon: 'success',
            title: 'Your work has been saved',
            showConfirmButton: false,
            timer: 1500


        }).then(function () {

                const email = document.getElementById("email").value;
                const id_province = document.getElementById("select-form").value;
                console.log("Id is: "+id_province);

                const firstName = document.getElementById("firstName").value;
                const lastName = document.getElementById("lastName").value;


                let customerData = {
                    firstName: firstName,
                    province: id_province,
                    email: email,
                    lastName: lastName,

                };



                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    type: "post",
                    data: JSON.stringify(customerData),
                    url: "/create",
                    success: function (data) {
                        $('#frmCreateCustomer')[0].reset();

                        // $('#table-customer').prepend("<tr id='" + data.id + "-a'><td>" + data.id + "</td><td>"
                        //     + data.fullName +
                        //     "</td><td>" + customerData.phone + "</td><td>" + customerData.address + "</td>"
                        //
                        //     + " <td>\n" +
                        //     "\n" +
                        //     "                <button class=\"btn btn-danger\" value='" + data.id + "'onclick=\"getEdit(this.value)\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                        //     "                    Edit\n" +
                        //     "                </button>\n" +
                        //     "\n" +
                        //     "            </td>\n" +
                        //     "            <td>\n" +
                        //     "\n" +
                        //     "                <button class=\"btn btn-primary\" value='" + data.id + "' onclick=\"getDelete(this.value)\">\n" +
                        //     "                    Delete\n" +
                        //     "                </button>\n" +
                        //     "\n" +
                        //     "            </td>" +
                        //     "</tr>");


                    },

                });


            },
        )



}

