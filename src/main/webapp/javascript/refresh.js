$("tbody >tr").each(function(){
    $(this).hover(function(){
        $(this).attr("title", "test toolip");
    })
})