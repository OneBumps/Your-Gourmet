// 固定标题栏
(function () {
  function fixedTitleBar() {
    let topBar = document.querySelector('.top-bar');
    if (document.documentElement.scrollTop > titleBarTop) {
      document.querySelector('main .top-bar+form div').classList.add('add-first-item-margin');
      topBar.classList.add('fixed-top-bar');
      topBar.classList.remove('wrapper');
    } else {
      document.querySelector('main .top-bar+form div').classList.remove('add-first-item-margin');
      topBar.classList.remove('fixed-top-bar');
      topBar.classList.add('wrapper');
    }
  }
  let titleBarTop = document.querySelector('.top-bar').offsetTop;
  window.addEventListener('scroll', fixedTitleBar);
})();

// 校验表单
(function () {
  let form = document.querySelector('form');
  function verif() {
    const [name, , description] = form;
    let menuNameWarning = document.querySelector('.menu-name #unavailable');
    let menuDescWarning = document.querySelector('.menu-introduction .text-warning');
    // 菜谱名字不能为空
    if (name.value.trim() === '') {
      menuNameWarning.classList.add('show-info');
      menuNameWarning.classList.remove('hide-info');
      menuNameWarning.innerHTML = '菜谱名字不能为空';
      return;
    } else {
      $.ajax({
        method: 'GET',
        url: 'http://localhost/YourGourmet/Verify',
        data: {
          type: 'verifyMenuName',
          name: name.value.trim()
        },
        success: function (info) {
          if (info == "true") {
            menuNameWarning.classList.add('show-info');
            menuNameWarning.classList.remove('hide-info');
            menuNameWarning.innerHTML = '菜谱名字已存在';
          } else {
            menuNameWarning.classList.remove('show-info');
            menuNameWarning.classList.add('hide-info');
          }
        }
      });
    }
    // 菜谱名字不能超过300个字符
    if (description.value.trim().length > 30) {
      menuDescWarning.classList.add('show-info');
      menuDescWarning.classList.remove('hide-info');
      return;
    } else {
      menuDescWarning.classList.remove('show-info');
      menuDescWarning.classList.add('hide-info');
    }
  }
  document.querySelector(".submit-menu").addEventListener('click', verif);
})();

// 保存到本地缓存
(function(){
  
})();