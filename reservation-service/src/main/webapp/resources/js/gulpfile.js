var gulp = require('gulp');
var concat = require('gulp-concat');
var uglify = require('gulp-uglify');
 var livereload = require('gulp-livereload');
var babel = require('gulp-babel');


var src = 'public/src';
var dist = 'public/dist';

var paths = {
	js: src + '/*.js'
};




// 자바스크립트 파일을 하나로 합치고 압축한다.
gulp.task('combine-js', function () {
	return gulp.src(paths.js)
		.pipe(babel({	// 바벨 이용하여 es6를 ex5로 변환
			presets : ["es2015"]
		}))
		.pipe(concat('script.js'))
		.pipe(uglify())
		.pipe(gulp.dest(dist));
});

// 파일 변경 감지 및 브라우저 재시작
gulp.task('watch', function () {
	livereload.listen();
	gulp.watch(paths.js, ['combine-js']);
	gulp.watch(dist + '/**').on('change', livereload.changed);
});

//기본 task 설정
gulp.task('default', [
	'combine-js', 'watch']);



