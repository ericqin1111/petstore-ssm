//
// $(document).ready(function (){
//     $("area").on('mouseenter', function() {
//
//         console.log($("area").length)
//       var categoryId = $(this).attr("data-categoryId");
//       console.log(categoryId);
//
//       $.ajax({
//           url:'/account/getDesn',
//           method:'GET',
//           data:{categoryId:categoryId},
//
//           success:function (response) {
//               var productListInfo = response;
//
//               var tipContent = "<div class='product-list' id='product-list'>";  // 使用一个容器来包裹商品列表
//
//               // 遍历商品列表并生成对应的内容
//               productListInfo.forEach(function (product) {
//                   var cleanDescription = product.description.replace(/<.*?>/g, '');
//                   tipContent += `
//                 <div class="product-item" id="product-item">
//
//                     <div class="product-name" >${product.name}</div>
//                     <div class="product-description">${cleanDescription}</div>
//
//                 </div>
//             `;
//               });
//
//
//               $("#tip-content").html(tipContent);
//
//                   // var tooltipWidth = $("#tip").outerWidth();
//                   // var tooltipHeight = $("#tip").outerHeight();
//
//                   var windowWidth = $(window).width();
//                   var tooltipWidth = windowWidth / 3;
//
//                     var xPos = windowWidth - tooltipWidth-90;  // 右边缘留 15px
//                     var yPos = 90;  // 可以根据需要调整 Y 轴位置
//                   // var xPos = event.clientX + 15;
//                   // var yPos = event.clientY - tooltipHeight / 2;
//
//                   // 防止悬浮窗超出视口
//                   // if (xPos + tooltipWidth > $(window).width()) {
//                   //     xPos = event.clientX - tooltipWidth - 15;
//                   // }
//                   // if (yPos + tooltipHeight > $(window).height()) {
//                   //     yPos = $(window).height() - tooltipHeight - 15;
//                   // }
//
//               $("#tip").css({
//                   position:'absolute',
//                   width: tooltipWidth + "px",  // 设置宽度
//                   left: xPos + "px",  // 定位到右侧
//                   top: yPos + "px"  // 可以根据需要调整 top 值
//               }).show();
//
//                   // $("#tip").css({ left: xPos + "px", top: yPos + "px" }).show();
//
//               },
//
//           error: function() {
//               setTimeout(function() {
//                   $("#tip").hide();
//               }, 100);  // 适当延迟
//           }
//       })
//
//
//
//
//   })
//
//
//     $("area").on('mouseleave', function() {
//         $("#tip").hide();
//
//         console.log("leave1")
//     });
//
//     $(window).resize(function() {
//         var windowWidth = $(window).width();
//         var tooltipWidth = windowWidth / 3;  // 让悬浮窗占据浏览器宽度的1/3
//         $("#tip").css("width", tooltipWidth);
//     });
//
//
//     // $('.product-list2').each(function (event) {
//     //
//     //     // var description='<image src="images/cat2.gif">Great for reducing mouse populations';
//     //     var description = $(this).attr('data-description');  // 获取产品描述
//     //     console.log("Description2:", description);
//     //     var productId = $(this).attr('data-id');  // 获取产品ID
//     //
//     //     if (!description) {
//     //         console.error('Product description is empty or undefined for product-id:', productId);
//     //         return;  // 如果描述为空或未定义，跳过该项
//     //     }
//     //
//     //     var regex = /<image\s+src=["']([^"']+)[^>]*>/i;
//     //     // var regex =/<image\s+src="([^"]+)"/;
//     //     var match = description.match(regex);
//     //     if (match) {
//     //         var imageUrl = match[1];  // 提取到的图片地址
//     //         console.log(match[1]);
//     //         var imgElement=$('#id-'+productId);
//     //         if(imgElement.length>0){
//     //             imgElement.attr('src',imageUrl);
//     //         }
//     //         else {
//     //             console.error('no image element found:',productId)
//     //         }
//     //         // 设置对应图片的 src
//     //     }
//     // });
//
//
//
//
//
// })
