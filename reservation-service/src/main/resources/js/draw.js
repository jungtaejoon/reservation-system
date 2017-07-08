
function make_category_box(category) {
  return
    '<div class="category" id ="' + category.id + '">' +
        '<input type=button class="road_category" type="checkbox" checked>' +
        '<label>' + category.name + '</label>' +
    '</div>';
}
function draw_category_list(categories) {
  var str = '';
  for(var index in todos) {
     str += make_category_box(categories[index]);
  }
  $('#list').html(str);
