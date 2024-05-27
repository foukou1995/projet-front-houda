$(document).ready(function(){
//Adding
$("#addBtn").click(function(){
    const Value = document.getElementById("search").value;
    const li = document.createElement('li');
    const Button = document.createElement('button');
    const List =  document.getElementById("Listt");

    li.textContent=Value;
    Button.textContent = "Delete";

    li.classList.add('list-group-item d-flex justify-content-between align-items-center');
    Button.classList.add('btn btn-danger rmv');

    li.appendChild(li);
    li.appendChild(Button);
    List.appendchild(li);

});


//removing
    $(".rmv").click(function(){
    $(this.parentNode).remove();
});

});
