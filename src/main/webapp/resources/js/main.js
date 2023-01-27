$(document).ready(function () {

  var new_count = 1; //신작
  var romance_count = 1; //로맨스
  var fantasy_count = 1; //판타지
  var BL_count = 1; //BL

  /* NEW! 신작 페이징 AJAX */

  function newNovels() {
    $.ajax({
      url: '/newNovels',
      data: {'page': new_count},
      datatype: 'json',
      success: function (data) {
        for (let i = 0; i < data.length; i++) {
          var imgpath = "resources/images/novel/" + data[i].id + ".jpg";
          var description = "<div class='description'>"
              + "<div class='book_name'><a href='oneNovelPage?id=" + data[i].id
              + "&page=1" + "'>" + data[i].id + "</a></div>"
              + "<div class='writer'>" + data[i].title + "</div></div>";
          $("#newNovel").append(
              "<div class='item'><img src = " + imgpath + ">" + description
              + '</div>');
        }
      }
    });
  }

  $('#newNovelR').on('click', function () {
    new_count += 1;
    if (new_count === 21) {
      new_count = 1;
    }
    document.getElementById("new_page").innerHTML = new_count + "페이지";
    $('#newNovel').html("");
    newNovels();
  });

  $('#newNovelL').on('click', function () {
    new_count -= 1;
    if (new_count === 0) {
      new_count = 20;
    }
    document.getElementById("new_page").innerHTML = new_count + "페이지";
    $('#newNovel').html("");
    newNovels();
  });

  /* 로맨스/로판 BEST 페이징 AJAX */

  function romanceNovels() {
    $.ajax({
      url: '/romanceNovels',
      data: {'page': romance_count},
      datatype: 'json',
      success: function (data) {
        for (let i = 0; i < data.length; i++) {
          var imgpath = "resources/images/novel/" + data[i].id + ".jpg";
          var description = "<div class='description'>"
              + "<div class='book_name'><a href='oneNovelPage?id=" + data[i].id
              + "&page=1" + "'>" + data[i].id + "</a></div>"
              + "<div class='writer'>" + data[i].title + "</div></div>";
          $("#romanceNovel").append(
              "<div class='item'><img src = " + imgpath + ">" + description
              + '</div>');
        }
      }
    });
  }

  $('#romanceNovelR').on('click', function () {
    romance_count += 1;
    if (romance_count === 13) {
      romance_count = 1;
    }
    document.getElementById("romance_page").innerHTML = romance_count + "페이지";
    $('#romanceNovel').html("");
    romanceNovels();
  });

  $('#romanceNovelL').on('click', function () {
    romance_count -= 1;
    if (romance_count === 0) {
      romance_count = 12;
    }
    document.getElementById("romance_page").innerHTML = romance_count + "페이지";
    $('#romanceNovel').html("");
    romanceNovels();
  });

  /* 판타지/무협 BEST 페이징 AJAX */

  function fantasyNovels() {
    $.ajax({
      url: '/fantasyNovels',
      data: {'page': fantasy_count},
      datatype: 'json',
      success: function (data) {
        for (let i = 0; i < data.length; i++) {
          var imgpath = "resources/images/novel/" + data[i].id + ".jpg";
          var description = "<div class='description'>"
              + "<div class='book_name'><a href='oneNovelPage?id=" + data[i].id
              + "&page=1" + "'>" + data[i].id + "</a></div>"
              + "<div class='writer'>" + data[i].title + "</div></div>";
          $("#fantasyNovel").append(
              "<div class='item'><img src = " + imgpath + ">" + description
              + '</div>');
        }
      }
    });
  }

  $('#fantasyNovelR').on('click', function () {
    fantasy_count += 1;
    if (fantasy_count === 8) {
      fantasy_count = 1;
    }
    document.getElementById("fantasy_page").innerHTML = fantasy_count + "페이지";
    $('#fantasyNovel').html("");
    fantasyNovels();
  });

  $('#fantasyNovelL').on('click', function () {
    fantasy_count -= 1;
    if (fantasy_count === 0) {
      fantasy_count = 7;
    }
    document.getElementById("fantasy_page").innerHTML = fantasy_count + "페이지";
    $('#fantasyNovel').html("");
    fantasyNovels();
  });

  /* BL BEST 페이징 AJAX */

  function BLNovels() {
    $.ajax({
      url: '/BLNovels',
      data: {'page': BL_count},
      datatype: 'json',
      success: function (data) {
        for (let i = 0; i < data.length; i++) {
          var imgpath = "resources/images/novel/" + data[i].id + ".jpg";
          var description = "<div class='description'>"
              + "<div class='book_name'><a href='oneNovelPage?id=" + data[i].id
              + "&page=1" + "'>" + data[i].id + "</a></div>"
              + "<div class='writer'>" + data[i].title + "</div></div>";
          $("#BLNovel").append(
              "<div class='item'><img src = " + imgpath + ">" + description
              + '</div>');
        }
      }
    });
  }

  $('#BLNovelR').on('click', function () {
    BL_count += 1;
    if (BL_count === 3) {
      BL_count = 1;
    }
    document.getElementById("BL_page").innerHTML = BL_count + "페이지";
    $('#BLNovel').html("");
    BLNovels();
  });

  $('#BLNovelL').on('click', function () {
    BL_count -= 1;
    if (BL_count === 0) {
      BL_count = 2;
    }
    document.getElementById("BL_page").innerHTML = BL_count + "페이지";
    $('#BLNovel').html("");
    BLNovels();
  });

});
