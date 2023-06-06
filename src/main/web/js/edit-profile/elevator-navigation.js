// 点击切换
(function () {
  document.querySelector('.sub-nav ul').addEventListener('click', function (e) {
    let ac = document.querySelector('.sub-nav .active-nav');
    if (e.target.tagName == 'A') {
      if (ac) ac.classList.remove('active-nav');
      e.target.classList.add('active-nav');
      const getTop = document.querySelector(`.wrapper div[data-title='${e.target.dataset.name}']`).offsetTop;
      document.documentElement.scrollTop = getTop - 300;
    }
  });
})();
// 滚动切换
window.addEventListener('scroll', function () {
  let ac = document.querySelector('.sub-nav .active-nav');
  if (ac) ac.classList.remove('active-nav');
  const getOffsetTop = document.documentElement.scrollTop + 300;
  const base = document.querySelector(".wrapper div[data-title='base']").offsetTop;
  const password = document.querySelector(".wrapper div[data-title='password']").offsetTop;
  const avatar = document.querySelector(".wrapper div[data-title='avatar']").offsetTop;
  const privacy = document.querySelector(".wrapper div[data-title='privacy']").offsetTop;
  const profile = document.querySelector(".wrapper div[data-title='profile']").offsetTop;
  const delete1 = document.querySelector(".wrapper div[data-title='delete']").offsetTop;
  if (getOffsetTop >= base && getOffsetTop < password) {
    document.querySelector(".sub-nav a[data-name='base']").classList.add('active-nav');
  } else if (getOffsetTop >= password && getOffsetTop < avatar) {
    document.querySelector(".sub-nav a[data-name='password']").classList.add('active-nav');
  } else if (getOffsetTop >= avatar && getOffsetTop < privacy) {
    document.querySelector(".sub-nav a[data-name='avatar']").classList.add('active-nav');
  } else if (getOffsetTop >= privacy && getOffsetTop < profile) {
    document.querySelector(".sub-nav a[data-name='privacy']").classList.add('active-nav');
  } else if (getOffsetTop >= profile && getOffsetTop < delete1 - 400) {
    document.querySelector(".sub-nav a[data-name='profile']").classList.add('active-nav');
  } else if (getOffsetTop >= delete1 - 400) {
    document.querySelector(".sub-nav a[data-name='delete']").classList.add('active-nav');
  }
});