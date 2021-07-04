<!--Create-->

function doCreateEmployee() {

    Swal.fire({

        title: 'Create Employee Success!!!',

        width: 700,
        padding: '12em',
        background: '#fff url("https://i.pinimg.com/originals/a8/07/91/a80791746c66c382faf2209c02926b6e.gif")',
        timer: 2500,
        showConfirmButton: false
    }).then(function () {

            const email = document.getElementById("email").value;
            const id_province = document.getElementById("select-form").value;
            console.log("Id is: " + id_province);

            const firstName = document.getElementById("firstName").value;
            const lastName = document.getElementById("lastName").value;

            let provinceData = {
                id: id_province
            }
            let employeeData = {
                firstName: firstName,
                email: email,
                lastName: lastName,
                province: provinceData

            };


            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                type: "post",
                data: JSON.stringify(employeeData),
                url: "/create",
                success: function (employeeEntity1) {
                    $('#frmCreateCustomer')[0].reset();
                    console.log(employeeEntity1);

                    $('#add-row').prepend("    <tr id='" + employeeEntity1.id + "-a'>\n" +
                        "                <th >" + employeeEntity1.id + " </th>\n" +
                        "                <td id='" + employeeEntity1.id + "-firstName'>" + employeeEntity1.firstName + " </td>\n" +
                        "                <td id='" + employeeEntity1.id + "-lastName'>" + employeeEntity1.lastName + " </td>\n" +
                        "                <td id='" + employeeEntity1.id + "-email' >" + employeeEntity1.email + " </td>\n" +
                        "                <td id='" + employeeEntity1.id + "-province'>" + employeeEntity1.province.name + " </td>\n" +
                        "                <td>\n" +
                        "                    <button class=\"btn btn-danger\" value='" + employeeEntity1.id + "'  \n" +
                        "                            data-toggle=\"modal\" data-target=\"#myModal\"  onclick=\"getEdit(this.value)\" >\n" +
                        "                        Edit\n" +
                        "                    </button>\n" +
                        "<!--                    onclick=\"getEdit(this.value)\"   onclick=\"getDelete(this.value)\"-->\n" +
                        "                </td>\n" +
                        "                <td>\n" +
                        "                    <button class=\"btn btn-primary\" value='" + employeeEntity1.id + "' onclick=\"getDelete(this.value)\" >\n" +
                        "                        Delete\n" +
                        "                    </button>\n" +
                        "                </td>\n" +
                        "            </tr>");


                },
                error: function(XMLHttpRequest, textStatus, errorThrown) {
                    alert("Status: " + textStatus); alert("Error: " + errorThrown);
                }

            });


        },
    )


}

<!--Delete-->

function getDelete(value) {

    Swal.fire({
        title: 'Are you sure?',
        text: "You won't be able to revert this!",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: 'Yes, delete it!'
    }).then(function (result) {
            if (result.isConfirmed) {
                $.ajax({
                    type: "post",
                    url: "/delete/" + value,
                    data: {'id': value},

                    success: function () {


                        swal.fire(
                            "Success!",
                            "Your note has been deleted!",
                            "success"
                        )
                        document.getElementById(value + "-a").innerHTML = "";
                    },


                });
            }

        },
        function (dismiss) {
            if (dismiss === "cancel") {
                swal(
                    "Cancelled",
                    "Canceled Note",
                    "error"
                )
            }
        })
}

<!--    Edit-->
function getEdit(id) {
    console.log("Edit Id: "+id);
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        data: JSON.stringify(id),
        url: "/edit",
        success: function (data) {


            $('#inputFirstName').val(data.firstName);
            $('#inputEmail').val(data.email);
            $('#inputLastName').val(data.lastName);
            $('#province-select').val(data.province.id);
            $('#inputId').val(data.id);
        },

    });
}

<!--    Submit Edit-->
function submitEdit() {
    const email = document.getElementById("inputEmail").value;
    const id = document.getElementById("inputId").value;
    const inputFirstName = document.getElementById("inputFirstName").value;
    const inputLastName = document.getElementById("inputLastName").value;
    const province_select = document.getElementById("province-select").value;


    let provinceData = {
        id: province_select
    }
    let employeeData = {
        id: id,
        firstName: inputFirstName,
        email: email,
        lastName: inputLastName,
        province: provinceData

    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "post",
        data: JSON.stringify(employeeData),
        url: "edit-customer",
        // success: function (data) {
        //     Swal.fire({
        //         icon: 'success',
        //         title: 'Edit Customer Successfully!',
        //         showConfirmButton: false,
        //         timer: 2000
        //     });
        //
        //
        //     // console.log(data);
        //     // console.log(data.firstName);
        //
        //     document.getElementById(data.id+"-firstName").innerHTML = data.firstName;
        //     document.getElementById(data.id+"-lastName").innerHTML = data.lastName;
        //     document.getElementById(data.id+"-email").innerHTML = data.email;
        //     document.getElementById(data.id+"-province").innerHTML = data.province.name;
        //
        // },

    }).done((data) =>{
        Swal.fire({
            icon: 'success',
            title: 'Edit Customer Successfully!',
            showConfirmButton: false,
            timer: 2000
        });


        // console.log(data);
        // console.log(data.firstName);

        document.getElementById(data.id+"-firstName").innerHTML = data.firstName;
        document.getElementById(data.id+"-lastName").innerHTML = data.lastName;
        document.getElementById(data.id+"-email").innerHTML = data.email;
        document.getElementById(data.id+"-province").innerHTML = data.province.name;
    }).fail(function () {
        alert("Status: " + textStatus); alert("Error: " + errorThrown);
    });
}