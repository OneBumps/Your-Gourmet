(function () {
  // 固定标题栏
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

  // 校验表单

  // 
})();