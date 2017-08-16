var path = require('path');

var webpack = require('webpack');

var dir_js = path.resolve(__dirname, '..');
var dir_detail = path.resolve(__dirname, 'detail');
var dir_mainpage = path.resolve(__dirname, 'mainpage');
var dir_reserve = path.resolve(__dirname, 'reserve');
var dir_build = path.resolve(__dirname, 'build');

module.exports = {
    entry: {
        detail: path.resolve(dir_detail, 'detail.js'),
        mainpage: path.resolve(dir_mainpage, 'mainpage.js'),
        reserve: path.resolve(dir_reserve, 'reserve.js')
    },
    output: {
        path: dir_build,
        filename: '[name].bundle.js'
    },
    devServer: {
        contentBase: dir_build,
    },
    module: {
        loaders: [
            {
                loader: 'babel-loader',
                test: dir_js
            },
            {
                test: /\-template.html$/,
                loader: 'handlebars'
            }
        ]
    },
    plugins: [
        new webpack.NoErrorsPlugin()
    ],
    stats: {
        colors: true
    },
    devtool: 'source-map',
};
