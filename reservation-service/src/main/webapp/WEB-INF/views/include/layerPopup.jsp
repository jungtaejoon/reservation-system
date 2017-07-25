<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
.pop-layer .pop-container {
  padding: 20px 25px;
}

.pop-layer p.ctxt {
  color: #666;
  line-height: 25px;
}

.pop-layer .btn-r {
  width: 100%;
  margin: 10px 0 20px;
  padding-top: 20px;
  border-top: 1px solid #DDD;
  text-align: right;
}

.pop-layer {
  display: none;
  position: absolute;
  top: 50%;
  left: 50%;
  width: 70%;
  height: auto;
  background-color: #fff;
  border: 5px solid #3571B5;
  z-index: 10;
}

.dim-layer {
  display: none;
  position: fixed;
  _position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 100;
}

.dim-layer .dimBg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: #000;
  opacity: .5;
  filter: alpha(opacity=50);
}

.dim-layer .pop-layer {
  display: block;
}

a.btn-layerClose {
  display: inline-block;
  height: 25px;
  padding: 0 14px 0;
  border: 1px solid #304a8a;
  background-color: #3f5a9d;
  font-size: 13px;
  color: #fff;
  line-height: 25px;
}

a.btn-layerClose:hover {
  border: 1px solid #091940;
  background-color: #1f326a;
  color: #fff;
}

.pop-conts {
	text-align : center;
}
</style>

<div class="dim-layer">
    <div class="dimBg"></div>
    <div id="layer2" class="pop-layer">
        <div class="pop-container">
            <div class="pop-conts">
                   
                    <div class="group_visual">
                        <div>
                            <div class="container_visual">
                                <ul class="visual_img">
                                    <li class="item"> <img width="70%" height="20%" class="img_vertical_top" src="/comment/1/images" alt="리뷰이미지"> <span class="img_bg"></span>
                                        <div class="visual_txt">
                                            
                                        </div>
                                    </li>
                                    <li class="item"> <img width="70%" height="20%" class="img_vertical_top" src="/comment/1/images" alt="리뷰이미지"> <span class="img_bg"></span>
                                        <div class="visual_txt">
                                            
                                        </div>
                                    </li>
                                    <li class="item"> <img width="70%" height="20%" class="img_vertical_top" src="/comment/1/images" alt="리뷰이미지"> <span class="img_bg"></span>
                                        <div class="visual_txt">
                                            
                                        </div>
                                    </li>
                                </ul>
                            </div>
                            <div class="prev">
                                <div class="prev_inn">
                                    <a href="#" class="btn_prev" title="이전">
                                        <!-- [D] 첫 이미지 이면 off 클래스 추가 -->
                                        <i class="spr_book2 ico_arr6_lt off"></i>
                                    </a>
                                </div>
                            </div>
                            <div class="nxt">
                                <div class="nxt_inn">
                                    <a href="#" class="btn_nxt" title="다음">
                                        <i class="spr_book2 ico_arr6_rt"></i>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="btn-r">
                    <a href="#" class="btn-layerClose">Close</a>
                </div>
                <!--// content-->
            </div>
        </div>
    </div>
</div>