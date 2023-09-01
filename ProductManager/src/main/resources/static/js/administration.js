
const menu_product = document.getElementById('menu-product');

const navigation = document.querySelector('.click');

menu_product.addEventListener('click', () => {
    if (navigation.classList.contains('click')) {
        navigation.classList.remove('click');

    } else {
        navigation.classList.add('click');
    }
});

const colorChangeColor = document.querySelector('.colorChangeClick');

menu_product.addEventListener('click', (e) => {
    if (colorChangeColor.classList.contains('custom-link')) {
        colorChangeColor.classList.remove('custom-link');
        colorChangeColor.classList.add('clicked');
    } else {
        colorChangeColor.classList.remove('clicked');
        colorChangeColor.classList.add('custom-link');
    }
});

// col-md-10
document.addEventListener("DOMContentLoaded", function () {
    var showLinks = document.querySelectorAll(".show-link");
    var contentDivs = document.querySelectorAll("[id^='link']");
    showLinks.forEach(function (link) {
        link.addEventListener("click", function (event) {
            event.preventDefault();

            var target = this.getAttribute("data-target");
            contentDivs.forEach(function (div) {
                div.classList.add("hidden");
            });
            document.getElementById(target).classList.remove("hidden");
        });
    });
});

// thêm chi tiết sản phẩm size-color-quantity;
$("#add-variation").click(function () {
    var newVariation = `
    <div class="variation" style="border-bottom: 1px solid #c2c2c2;">
        <label  style="padding-left: 30px;" for="">Kích thước: </label>
        <select name="" id="" class="size" style="width: 80px;">
            <option value="">select</option>
            <option value="1">S</option>
            <option value="2">M</option>
            <option value="3">L</option>
            <option value="4">XL</option>
            <option value="5">XXL</option>
        </select>
        <label  style="padding-left: 90px;" for="">Màu sắc: </label>
        <select name="" id="" class="color" style="width: 80px;">
            <option value="">select</option>
            <option value="1">Đen</option>
            <option value="2">Xám</option>
            <option value="3">Đỏ</option>
        </select>
        <label  style="padding-left: 90px;" for="">Số lượng: </label>
        <input type="number" name="" id="" class="quantity" min="1" max="100" style="width: 80px;" required>
        <a href="#" type="button" id="btn-delete-detail">
            <span class="icon" style="padding-left: 20px; margin-top: 2px; color: red;">
                <ion-icon name="trash-outline" style="margin-bottom: -5px;"></ion-icon>
            </span>
        </a>
    </div>
        `;
    $("#variation-container").append(newVariation);
});

// xoá chi tiết sản phẩm size-color-quantity
jQuery("#variation-container").on("click", "#btn-delete-detail", function () {
    $(this).closest(".variation").remove();
});

jQuery('#save-product').click(function () {

    var list = [];

    jQuery('.variation').each(function () {
        var size = $(this).find('.size').val();
        var color = $(this).find('.color').val();
        var quantity = $(this).find('.quantity').val();

        var detail = {
            size: size,
            color: color,
            quantity: quantity
        };

        list.push(detail);
    });


    var shirtDTO = {
        name: jQuery('.product-name').val(),
        madeIn: jQuery('.production-site').val(),
        url: jQuery('.image').val(),
        price: jQuery('.price-product').val()
    };

    var requestShirt = {
        shirtDTO: shirtDTO,
        list: list
    };

    if (jQuery('#selecter').val() === 'shirt') {
        jQuery.ajax({

            url: 'http://localhost:8080/api/v1/save/shirt',

            type: 'POST',

            data: JSON.stringify(requestShirt),

            contentType: 'application/json',

            success: function (response) {
                if (response.status == 200) {
                    alert('Sản phẩm đã được lưu thành công!');
                } else {
                    alert('Tên sản phẩm đã tồn tại!');
                }
            },
            error: function (error) {
                alert('Lỗi trong quá trình thực thi!');
            }
        });
    } else if (jQuery('#selecter').val() === 'pant') {
        jQuery.ajax({

            url: 'http://localhost:8080/api/v1/save/pant',

            type: 'POST',

            data: JSON.stringify(requestBody),

            contentType: 'application/json',

            success: function (response) {
                if (response.status === 200) {
                    alert('Sản phẩm đã được lưu thành công!');
                } else {
                    alert('Tên sản phẩm đã tồn tại!');
                }
            },
            error: function (error) {
                alert('Lỗi trong quá trình thực thi!');
            }
        });
    }
});



