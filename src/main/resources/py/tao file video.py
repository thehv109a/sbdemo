cat > viewPlus.py <<EOF
import requests
import json
import random

videos = []
lapTrinhs = []
sanCos = []
tiktok365s = []
docLas = []
sucKhoes = []
duLichs = []
thuyLinhs = []
handmades = []
tiktokdane = []
gamingbox = []
muzik = []

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_4107&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    lapTrinhs.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_4105&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    sanCos.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_201923&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    tiktok365s.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))
    
contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_4106&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    docLas.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_4104&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    sucKhoes.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_201893&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    duLichs.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_227859&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    thuyLinhs.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))
    
contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_201899&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    handmades.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_234239&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    tiktokdane.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_234279&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    gamingbox.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_234279&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    gamingbox.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn:3002/v1/common/get-more-contents?id=video_new_of_channel_234277&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    muzik.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))


videoss = duLichs[:] + thuyLinhs[:] + handmades[:] + tiktokdane[:] + gamingbox[:] + muzik[:]

index = 0
sttvideo = 10
new_links = []

for item in videoss:
    index = index+1
    new_links.append(item)
    if (index==30):
        with open("/bloggt/files/videos"+ str(sttvideo)+".txt", "w") as text_file: text_file.write('\n'+'\n'.join(new_links))
        sttvideo = sttvideo+1
        new_links = []
        index = 0

EOF
python viewPlus.py
