

$(document).ready(function () {
    $('#dataTable').DataTable();
    $("#createCategorie").on('click', function () {
        console.log("create");
        let nom = $("#createCategorieData .nom").val();
        let label = $("#createCategorieData .label").val();
        let info = $("#createCategorieData .info").val();
        jQuery.get("CategorieServlet", {
            actionCategorie: "create",
            nom: nom,
            label: label,
            info: info
        }).done(function (msg) {
            alert(msg);
        })
    })
    $("#MAJCategorie").on('click', function () {
        console.log("update");
        let nom = $("#updateCategorieData .nom").val();
        let label = $("#updateCategorieData .label").val();
        let info = $("#updateCategorieData .info").val();
        jQuery.get("CategorieServlet", {
            actionCategorie: "update",
            nom: nom,
            label: label,
            info: info
        }).done(function (msg) {
            alert(msg);
        })
    })
    $("#deleteCategorie").on('click', function () {
        console.log("remove");
        let nom = $("#removeCategorieData .nom").val();
        let label = $("#removeCategorieData .label").val();
        let info = $("#removeCategorieData .info").val();
        jQuery.get("CategorieServlet", {
            actionCategorie: "remove",
            nom: nom,
            label: label,
            info: info
        }).done(function (msg) {
            alert(msg);
        })
    })
});
$(dataTable).ready(function () {
    $('#myTable').dataTable();
});

function updateNewAsset() {
    jQuery.get("CategorieServlet", {
        actionCategorie: "getall"
    }, function (list) {
        let select = $(".categorieId");
        select.each(function(){
            select.empty()
            $.each(list, function (id, categorie) {
                select.append("<option value='" + categorie.id + "'>" + categorie.nom + "</option>");
            })
        })
    })
}

/*
$(window).on('load', function () {
    updateButton();
})

function updateButton() {
    $.each($(".updateAsset"), function () {
        $(this).off('click');
        $(this).on('click', function () {
            $("#updateAssetData .numberofaction").val("");
            updateId = parseInt(($(this).attr('id')).charAt(4));
        })
    })
    $.each($(".removeAsset"), function () {
        $(this).off('click');
        $(this).on('click', function () {
            $("#removeCheck .yes").prop("checked", false);
            removeId = parseInt(($(this).attr('id')).charAt(6));
            console.log(removeId);
        })
    })
}

function update() {
    updateData();
    refresh();
    updateNewAsset();
    updateAssetsList();
}

function updateAssetsList() {
    jQuery.get("list", {
        list: "refresh"
    }).done(function (assetList) {
        let table = $("#assetslisting");
        table.empty();
        console.log(assetList);
        $.each(assetList, function (id, assets) {
            table.append("<tr></tr>");
            let tr = $("#assetslisting > tr:last-child");
            tr.append("<td>" + assets[0] + "</td>");
            tr.append("<td>" + assets[1] + "</td>");
            tr.append("<td>" + assets[2] + "</td>");
            tr.append("<td>" + assets[3] + "</td>");
            tr.append("<td>" + assets[4] + "</td>");
            tr.append("<td><span class='updateAsset' id='edit" + assets[5] + "'><i class='fas fa-pen' data-toggle='modal' data-target='#updateAsset'> </i></span><span class='removeAsset' id='remove" + assets[5] + "'><i class='far fa-trash-alt' data-toggle='modal' data-target='#removeAsset'> </i></span></td>")
        })
        updateButton();
    })
}


function updateData() {
    jQuery.get("CRUDCurrency", {
        crypto: "list"
    }).done(function (list) {
        let select = $("#idselector select");
        $("#showlist").empty();
        $("#showlist").append("<div class='row'></div>");
        let div = $("#showlist div:first-child");
        div.append("<div class='col-xs-1-1'><h4>" + "Id" + "</h4></div>");
        div.append("<div class='col-xs-3-3'><h4>" + "Name" + "</h4></div>");
        div.append("<div class='col-xs-5-5'><h4>" + "Label" + "</h4></div>");
        div.append("<div class='col-xs-7-7'><h4>" + "Actual Price" + "</h4></div>");
        select.empty();
        $.each(list, function (id, currency) {
            select.append("<option value='" + currency.id + "'>" + currency.name + "</option>")
            $("#showlist > div > div:nth-child(1)").append("<p>" + currency.id + "</p>");
            $("#showlist > div > div:nth-child(2)").append("<p>" + currency.name + "</p>");
            $("#showlist > div > div:nth-child(3)").append("<p>" + currency.label + "</p>");
            $("#showlist > div > div:nth-child(4)").append("<p>" + currency.actualPrice + "</p>");
        });
    })
}

function refresh() {
    jQuery.get("navbar", {
        navbar: "refresh"
    }).done(function (data) {
        data = parseFloat(data);
        $("#totalAssets").removeClass().empty().text(data);
        if (data > 0) {
            $("#totalAssets").addClass("text-success");
        } else {
            $("#totalAssets").addClass("text-danger");
        }
    })
}

function updateNewAsset() {
    jQuery.get("navbar", {
        navbar: "list"
    }, function (list) {
        let select = $("#idselectorAsset select");
        select.empty()
        $.each(list, function (id, currency) {
            select.append("<option value='" + currency.id + "'>" + currency.name + "</option>");
        })
    })
}*/