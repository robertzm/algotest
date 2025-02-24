今天面完了5轮onsite，3 coding + bq+ sd，下面是面试前我自己整理的地理面经（3月到现在），onsite和电面的题目全在里面。如果时间不多，1～2个月内就面试，你看这一个帖子差不多就够了

算法题目，下面是leetcode题号
1 - 100: 7, 19, 21, 23, 26,  31, 34, 39, 43, 50, 56, 60, 62, 65, 71, 76, 79, 88

101 - 200: 116, 121, 125, 127, 129, 133, 138, 140, 146, 162, 190, 199, 200

201 - 400: 207, 210, 215, 219, 224, 227, 236, 249, 266, 283, 295, 301, 314, 317, 332, 339(不是给List，而是给字符串，可以用stack解题), 346, 347, 380

401 - 1000: 408, 426, 435, 437, 438, 443, 447, 494, 499, 523, 528, 543, 560, 658, 680, 721, 739(单调栈的典型应用), 791, 827, 934, 938, 973, 986, 987

Above 1000: 1004, 1047, 1060, 1091, 1123, 1161, 1209, 1216, 1249, 1382, 1539, 1570, 1644, 1650, 1762, 1778



system design:

    Design a chess game, 要求可以撤回上一步
    游戏leaderboard，需要有global&friends排名。这题准备过 但是面试官侧重点是怎么去sort我是没想到的
                 需要返回当前整个游戏的top N player、当前用户的前后N个player
                  返回当前用户朋友的top N player、当前用户朋友的前后N个player
    Hacker version Web crawler
    有一些限定条件，比如说一万台机器，尽可能让每台机器的load evenly distributed。
    Design an Ads Aggregation System (广告点击)
    facebook 評論系統: user1 看到某個post1, user1 write comment, user2 看到post2, write comment, 同時要通知user1
    design zoom
    Design instagram
    Design ig auction: 设计一个auction system。 用户可以view current bid price 然就可以bid with higher price。 主要问了如果bid at same‍‍‌‍‍‍‍‌‌‌‍‌‍‌‍‍‍‌‍‌ price 怎么解决conflict。以及怎么scale一个很hot的auction。
    ig newsfeed, 怎么处理new post来通知用户的情况
    design dropbox. 全程drive对话，自己说哪里是bottleneck，如何解决，面试官的问题都回答上了，后期dive in主要着重于how to chunk large file in detail, get updated file list 的时候如何提高performance，get updated file list的时候有什么edge case吗，如何解决。面试官最后looking very good。
    设计一个抢票系统
    trending hashtags: Top K 问题
    设计post的隐私设置
    proximity service
    price tracker
    design camel camel camel
    Ticketmaster
    deep dive facebook news feed API 包括pagination.. 如何实现at一个人等
    design Spotify
    Design hotel booking system.
    设计一个streaming service: 需要支持video play、recommendation、subscription
    Presence indicator
    设计google map中，选择一个地点，可以拖拽看到周围街景的那个功能。主要问了问怎么hash longtitude/latitude，看看alex xu绿皮书Google map那一章会有帮助。‍‍‌‍‍‍‍‌‌‌‍‌‍‌‍‍‍‌‍‌以及如何降低latency，如何存储image等等。
    metrics monitoring
    youtube
    LeetCode contest platform


bq:

conflict with others, xfn conflict
biggest mistake
have you ever broke prod code
most proud project
difficult working re‍‍‌‍‍‍‍‌‌‌‍‌‍‌‍‍‍‌‍‌lationship
conflict when you are right, conflict when you are wrong
feedback from mana‍‍‌‍‍‍‍‌‌‌‍‌‍‌‍‍‍‌‍‌ger: negative feedback, critical feedback you received
What did you learn from your tech lead, what do you want to improve?
多个task同时进行的时候怎么协调

补充内容 (2024-09-11 09:55 +08:00):
面senior的别担心算法，出的题目都是看一眼就知道答案。几年前拿过meta offer，当时还被面了2轮hard，现在算法要求降低很多。

补充内容 (2024-09-12 02:52 +08:00):
等我研究研究发出个pdf，让大家都能看

补充内容 (2024-09-13 02:48 +08:00):

pdf文件可以使用了，需要的尽快下载：
https://www.flipsnack.com/98EFDF5569B/meta/full-view.html


密码是这个问题的答案：孙悟空被压在五指山下多少年？答案是3个数字

补充内容 (2024-10-04 03:36 +08:00):
过期了，我也没有备份
