## url:[http://119.23.240.17/cgi-bin/User.py](http://119.23.240.17/cgi-bin/User.py)
第一次登入应用需要提供信息，以后用户更改信息也是直接调用这个cgi


### 输入格式：
{"deviceId":(str),"ifBindWeChat":(int),"ifBindFacebook":(int）,"WeChatId":（str）,"FacebookId":(str),"StatusSitLongCall":(int),"StatusCheckMood":(int)}

**输入只能一行**（懒得多行读入）

例：
{"deviceId":"zzr","ifBindWeChat":1,"ifBindFacebook":0,"WeChatId":"zzr","FacebookId":"","StatusSitLongCall":1,"StatusCheckMood":0}


### 输出格式
如果成功更改则返回{"status":"OK"}
如果失败（不存在的）：返回mysql的错误信息，一般是输入错了吧


## url:[http://119.23.240.17/cgi-bin/Mood.py](http://119.23.240.17/cgi-bin/Mood.py)
每一次记录心情调用这个cgi
### 输入格式：
{"deviceId":(str),"Time":(datatime),"Mood":(int),"Longitude":(double),"Latitude":(double)}
datatime格式 yyyy-mm-dd hh:mm:ss(要求比较严格）

**输入只能一行**

例：
{"deviceId":"zzr","Time":"2018-03-16 09:57:22","Mood":2,"Longitude":132.4242,"Latitude":50.1231}

### 输出格式：
如果成功更改则返回{"status":"OK"}
如果失败（不存在的）：返回mysql的错误信息，一般是还没调用过User.py（因为deviceId是外键）

## url:[http://119.23.240.17/cgi-bin/MoodHistory.py](http://119.23.240.17/cgi-bin/MoodHistory.py)
### 输入格式：
{"deviceId":(str),[可选]"StartTime":(datatime),[可选]"Limit":num}

例：
{"deviceId":"zzr","StartTime":"2017-01-01 00:00:00","Limit":100}

StartTime是返回从这个时间点开始的记录
Limit是返回记录的最大数量

这两个可以不填

**输入只能一行**

### 输出格式：
如果成功：
{'Mood=1': 0, 'MoodHistory': (('zzr', '2018-3-16 09:57:22', 2, 132.4242, 50.1231),), 'Mood=2': 1, 'Mood=0': 0}
（这是一个Dict,字典输出顺序不固定）
MoodHistory是一个元组，为查询的结果，为(deviceId,Time,Mood,Longitude,Latitude)按照时间从后往前排序

注意到ppt上有统计心情数量，以及貌似只有三个心情，所以我就顺带查询了每个心情的数量且目前心情种类记录为0,1,2

如果失败：
这个可能比较大（自己样例调试没法出太大的数据），还是返回mysql错误信息
