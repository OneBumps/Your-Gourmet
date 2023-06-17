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
// 校验菜谱名称是否重复
document.querySelector(".menu-name input[name='menuName']").addEventListener('blur', function () {
  $.ajax({
    method: 'GET',
    url: '/Verify',
    data: {
      type: 'verifyMenuName',
      name: this.value.trim()
    },
    success: function (info) {
      if (info == "true") {
        menuNameWarning.classList.add('show-info');
        menuNameWarning.classList.remove('hide-info');
        menuNameWarning.innerHTML = '菜谱名字已存在,确定创建同名菜谱？';
      } else {
        menuNameWarning.classList.remove('show-info');
        menuNameWarning.classList.add('hide-info');
      }
    }
  });
});

// 添加图片
document.querySelector("#updateImg").addEventListener('change', function () {
  const files = this.files;
  document.querySelector(".photo-bar").innerHTML = "";
  for (let i = 0; i < files.length; i++) {
    document.querySelector(".photo-bar").innerHTML = "<img alt='预览图'></img>" + document.querySelector(".photo-bar").innerHTML;
    document.querySelector(".photo-bar img:nth-child(1)").src = window.URL.createObjectURL(this.files[i]);
  }
});

// 获取textarea字数并限制最大字数
document.querySelector("textarea[name='menuIntroduction']").addEventListener("input", function (e) {
  let maxLength = 500;
  if (this.value.length > maxLength) {
    this.value = this.value.slice(0, maxLength);
  }
  document.querySelector(".additional span").innerHTML = this.value.length;
});

// 添加食材
(function () {
  let index = 2;
  document.querySelector("#addIngredient").addEventListener('click', function () {
    const ingredientGroup = document.querySelector('.ingredient-group');
    const newIngredientGroup = `
      <div class="ingredient-group">
        <input type="text" name="ingredient-${index}" placeholder="输入食材名称" />
        <input type="text" name="dosage-${index++}" placeholder="输入食材用量" />
      </div>
    `;
    ingredientGroup.insertAdjacentHTML('beforebegin', newIngredientGroup);
  });
})();

// 菜单步骤
(function () {
  let index = 2;
  // 添加步骤
  document.querySelector(".menu-steps").addEventListener('click', function (e) {
    if (e.target.classList.contains('addStep')) {
      const stepGroup = document.createElement('div');
      stepGroup.classList.add('step-group')
      stepGroup.innerHTML = `
        <label>
          <input
            type="file"
            name="menuSteps-${index}"
            max="10000000"
            accept="image/*"
          />
          <i class="iconfont icon-icadd"></i>
          <span>添加图片</span>
        </label>
        <div class="step-list">${index}</div>
        <textarea
          name="stepDescription-${index}"
          placeholder="请输入步骤描述"
          class="stepDescription"
        ></textarea>
        <div class="step-action-bar">
          <a href="javascript:;"><i class="iconfont icon-icadd addStep">添加</i></a>
          <a href="javascript:;"
            ><i class="iconfont icon-delete delete-step deleteStep" id="deleteStep-${index++}">删除</i></a
          >
        </div>
        `;
      this.appendChild(stepGroup);
      flashList();
    }
  });
  // 删除步骤
  document.querySelector(".menu-steps").addEventListener('click', function (e) {
    if (e.target.classList.contains('deleteStep') && e.target.nodeName == 'I') {
      e.stopPropagation();
      // let currentIndex = e.target.id.match(/\d+$/)[0];
      e.target.parentElement.parentElement.parentElement.remove();
      flashList();
    }
  });
  // 重新刷新序列号
  function flashList() {
    document.querySelectorAll('.step-list').forEach(function (currentIndex, i) {
      currentIndex.innerHTML = i + 1;
    })
  }
})();

// 显示步骤图片
document.querySelector(".menu-steps").addEventListener('change', function (e) {
  e.stopPropagation();
  e.target.nextSibling.nextSibling.style.backgroundImage = `url(${window.URL.createObjectURL(e.target.files[0])})`;
});

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

// 保存
document.querySelector(".save-menu").addEventListener('click', function () {
  localStorage.setItem('menuName', document.querySelector('input[name=menuName]').value.trim());
  localStorage.setItem('menuIntroduction', document.querySelector('textarea[name=menuIntroduction]').value.trim());
});
// 取出
(function() {
  if(localStorage.getItem('menuName')){
    document.querySelector('input[name=menuName]').value = localStorage.getItem('menuName');
  }
  if(localStorage.getItem('menuIntroduction')){
    document.querySelector('textarea[name=menuIntroduction]').value = localStorage.getItem('menuIntroduction');
  }
})();