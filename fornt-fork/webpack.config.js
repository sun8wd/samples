var webpack = require('webpack');
var window = require('window')
var htmlWebpackPlugin = require('html-webpack-plugin');
var path  = require('path');
var jquery = require('jquery');

module.exports = {
	context : __dirname,
	entry : {
		/*
		main : './src/js/main.js'
		app : './src/app.js'*/
		hello : ['./src/js/hello.js','./src/js/main.js']
	},
	output : {
		path : './dist',
		//filename : 'js/[name]-[chunkhash:8].bundle.js'
		filename : 'js/[name].bundle.js'
		//publicPath : 'https:www.celloud.cn/' 上线地址
	},
	module : {
		loaders : [
		 {test: /\.html$/,loader: 'html-withimg-loader'},
		{test: /\.html$/, loader: 'raw-loader'},
		{test:/\.js$/,loader:'babel-loader',exclude:path.resolve(__dirname,'node_modules'),
		//绝对路径 只解析src下的提高打包性能
		include:path.resolve(__dirname,'src')},
		{test:/\.css$/,loader:'style-loader!css-loader'},
		{test:/\.scss$/,loader:'style-loader!css-loader!sass-loader'},
		{test: /\.(png|jpg|jpg|ttf|eot|woff|woff2|svg)$/, loader: 'url-loader'}
		]
	},
	plugins : [
		new htmlWebpackPlugin({
			template: './src/index.html',
			filename : 'index.main.html',//-[chunkhash:8]
			inject : 'body',
			title : 'oms',
			date : new Date(),
			minify : {
				//删除注释
				removeComments : true,
				//删除空格
				collapseWhitespace : true
			}
		}),
		new webpack.ProvidePlugin({
			$ : 'jquery',
			jQuery : 'jquery',
			'window.jQuery' : 'jquery' 
		})
		]
}
