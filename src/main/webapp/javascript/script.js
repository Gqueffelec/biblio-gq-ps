$(document).ready(function () {
    updateCategorieList();
    $.each($(".categorieData"), function () {
        $(this).hide();
    })
    $('#dataTable').DataTable();
    $("#createCategorie").on('click', function () {
        console.log("create");
        let nom = $("#createCategorieData .nom").val();
        let label = $("#createCategorieData .label").val();
        let info = $("#createCategorieData .info").val();
        jQuery.get("createCategorie", {
            nom: nom,
            label: label,
            info: info
        }).done(function (msg) {
            alert(msg);
            $("#newCategorie").modal("hide");
            updateCategorieList();
        })
    })
    $("#MAJCategorie").on('click', function () {
        console.log("update");
        let categorieUpdateId = $("#updateCategorie").find(".categorieId").val();
        let nom = $("#updateCategorieData .nom").val();
        let label = $("#updateCategorieData .label").val();
        let info = $("#updateCategorieData .info").val();
        jQuery.get("updateCategorie", {
            id: categorieUpdateId,
            nom: nom,
            label: label,
            info: info
        }).done(function (msg) {
            alert(msg);
            $("#updateCategorie").modal("hide");
            updateCategorieList();
        })
    })
    $("#deleteCategorie").on('click', function () {
        let idToRemove = $("#removeCategorie .categorieId").val();
        console.log(idToRemove);
        jQuery.get("removeCategorie", {
            id: idToRemove
        }).done(function (msg) {
            alert(msg);
            $("#removeCategorie").modal("hide");
            updateCategorieList();
        })
    })
    $("#selectIdUpdate").on('click', function () {
        let categorieUpdateId = $("#updateCategorie").find(".categorieId").val();
        jQuery.get("getCategorie", {
            id: categorieUpdateId
        }).done(function (json) {
            console.log(json);
            $("#updateCategorieData").find(".nom").val(json.nom);
            $("#updateCategorieData").find(".label").val(json.label);
            $("#updateCategorieData").find(".info").val(json.information_technique);
            $("#updateCategorieData").show();
            $("#updateSelectId").hide();
            $("#MAJCategorie").removeAttr("disabled");
        }).fail(function () {
            alert("Erreur de requete");
        })
    })
    $("#updateCategorieButton").on("click", function () {
        $("#updateSelectId").show();
        $("#updateCategorieData").hide();
        $("#updateCategorieData").find(".nom").val("");
        $("#updateCategorieData").find(".label").val("");
        $("#updateCategorieData").find(".info").val("");
        $("#MAJCategorie").attr("disabled", true);
    })
});
$(dataTable).ready(function () {
    $('#myTable').dataTable();
});

function updateCategorieList() {
    jQuery.get("getAllCategorie", function (list) {
        console.log(list);
        let select = $(".categorieId");
        select.each(function () {
            select.empty()
            $.each(list, function (id, categorie) {
                select.append("<option value='" + categorie.id + "'>" + categorie.nom + "</option>");
            })
        })
    })
}