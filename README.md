# ShowVersion
[DOWNLOAD](https://plugins.jetbrains.com/plugin/10474-showversion)
### This plugin provides a panel showed versionName of every module of a Android Project,when we are practicing CI(Continuous Integration) or other rapid iteration model,I usually forget my Working copy belongs to which version （Especially the VCS was svn ）.
### Install this plugin,then click ShowVersion,the panel will be shown,it helps you quickly find the versionName of every module.
### Click the TextArea,the gradle file will open in editor view.
#### This is a raw version ,the sketch just as the following :
![png](https://github.com/tmac1999/ShowVersionTest/blob/master/tutorial/show_version_demo.png)


#### When click the TextArea,the gradle file will open in editor view.Like this:
![png](https://github.com/tmac1999/ShowVersionTest/blob/master/tutorial/show_version_demo2.png)

##### It still remains some todos:


##### 1.If use a VERSION reference in gradle file,I still cant figure out how to invoke the gradle method "getVersion()" .
##### 2.The panel was ugly :))
##### 3.Make the TextArea editable.
##### 4.Add more infomations about the module(Such as errors,code lines,file counts etc.) to the TextArea.
