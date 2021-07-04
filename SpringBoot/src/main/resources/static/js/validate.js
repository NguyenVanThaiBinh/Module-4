
$(() => {
    $(".validate_form").validate({
        errorElement: 'div',
        onclick: false,
        rules: {
            firstName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            inputLastName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            lastName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            email: {
                email: true,
                required: true,
                minlength: 5,
                maxlength: 50
            },
            province: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            phone: {
                number: true,
                minlength: 10,
                maxlength: 11
            },
            password: {
                required: false,
                validatePassword: true,
                minlength: 5
            }

        },
        messages: {
            firstName: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },
            lastName: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },
            email: {
                required: "Bắt buộc nhập email!",
                minlength: "Hãy nhập ít nhất 5 ký tự"
            },
            province: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },
        },
        submitHandler: function () {
            doCreateEmployee();
        }

    });
});


    // $.validator.addMethod("validatePassword", function (value, element) {
    //     return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
    // }, "Hãy nhập mật khẩu từ 5 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số");

    //Validate 2
$(() => {
    $("#frmUpdateCustomer").validate({

        errorElement: 'div-2',
        onclick: false,
        rules: {

            inputFirstName: {
                required: true,
                minlength: 4,
                maxlength: 40
            },
            inputLastName: {
                required: true,
                minlength: 5,
                maxlength: 50
            },
            inputEmail: {
                email: true,
                required: true,
                minlength: 5,
                maxlength: 50
            },
        },
        messages: {
            inputFirstName: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },
            inputLastName: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },
            inputEmail: {
                required: "Bắt buộc nhập email!",
                minlength: "Hãy nhập ít nhất 5 ký tự"
            },
            province: {
                required: "Bắt buộc nhập tên đầy đủ",
                minlength: "Hãy nhập tối thiểu 5 ký tự",
                maxlength: "Hãy nhập tối đa 50 ký tự"
            },
        },
        submitHandler: function () {
            console.log("Validate 2 done!")
            submitEdit();
            $("#myModal").modal('hide');
            $("form").validate().resetForm();
        }

    });


    // $.validator.addMethod("validatePassword", function (value, element) {
    //     return this.optional(element) || /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,16}$/i.test(value);
    // }, "Hãy nhập mật khẩu từ 5 đến 16 ký tự bao gồm chữ hoa, chữ thường và ít nhất một chữ số");


});


