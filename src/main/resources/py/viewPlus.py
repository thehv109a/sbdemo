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

contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_4107&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    lapTrinhs.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_4105&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    sanCos.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_201923&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    tiktok365s.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))
    
contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_4106&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    docLas.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_4104&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    sucKhoes.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_201893&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    duLichs.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_227859&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    thuyLinhs.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))
    
contents = requests.get("http://api.onmobi.vn/v1/common/get-more-contents?id=video_new_of_channel_201899&limit=2000&offset=0", headers={ 'User-Agent': 'Mozilla/5.0 (Windows NT 6.0; WOW64; rv:24.0) Gecko/20100101 Firefox/24.0' }).json()['data']['content']
for index, item in enumerate(contents): 
    click_medium = "201893"
    if index!=0: 
        click_medium = "related_of_video_"+ str(item['id'])
    handmades.append(item['link'].replace("?utm_source=APPSHARE", "?click_source=default&click_medium="+click_medium).replace("m.mobion.vn/video/", "mobion.vn/video/detail/"))

random.shuffle(lapTrinhs);
random.shuffle(sanCos);
random.shuffle(tiktok365s);
random.shuffle(docLas);
random.shuffle(sucKhoes)
random.shuffle(duLichs);
random.shuffle(thuyLinhs);
random.shuffle(handmades);

videoss = sanCos[:]+tiktok365s[:]+duLichs[:]+thuyLinhs[:]+handmades[:] +lapTrinhs[:]
random.shuffle(videoss)
videos =[]
for item in videoss: videos.append({"videoUrl":item})

users1 = [{"username":"0793298327","password":"123456"},{"username":"0704913036","password":"123456"},{"username":"0769363564","password":"123456"},{"username":"0769104231","password":"123456"},{"username":"0776872754","password":"123456"},{"username":"0796861577","password":"123456"}]

users2 = [{"username":"0788255426","password":"123456"},{"username":"0706319949","password":"123456"},{"username":"0793363952","password":"123456"},{"username":"0772874251","password":"123456"},{"username":"0788873309","password":"123456"},{"username":"0772130736","password":"123456"}]

users3 = [{"username":"0766409742","password":"123456"},{"username":"0787866436","password":"123456"},{"username":"0788929817","password":"123456"},{"username":"0936021460","password":"123456"},{"username":"0934674002","password":"123456"},{"username":"0782905498","password":"123456"}]

users4 = [{"username":"0706306115","password":"123456"},{"username":"0775448723","password":"123456"},{"username":"0778458912","password":"123456"},{"username":"0799628842","password":"123456"},{"username":"0706306115","password":"123456"},{"username":"0792215341","password":"123456"}]

users5 = [{"username":"0775448723","password":"123456"},{"username":"0778458912","password":"123456"},{"username":"0799628842","password":"123456"},{"username":"0796237891","password":"123456"},{"username":"0768805966","password":"123456"},{"username":"0706353580","password":"123456"}]

users6 = [{"username":"0769111340","password":"123456"},{"username":"0778407130","password":"123456"},{"username":"0769114174","password":"123456"},{"username":"0769106756","password":"123456"},{"username":"0898014564","password":"123456"},{"username":"0789696680","password":"123456"}]

users7 = [{"username":"0766967912","password":"123456"},{"username":"0783943688","password":"123456"},{"username":"0794200961","password":"123456"},{"username":"0766905851","password":"123456"},{"username":"0776345961","password":"123456"},{"username":"0707390669","password":"123456"}]

users8 = [{"username":"0797083394","password":"123456"},{"username":"0796932615","password":"123456"},{"username":"0763994987","password":"123456"},{"username":"0899023764","password":"123456"},{"username":"0931075634","password":"123456"},{"username":"0793226823","password":"123456"}]

users9 = [{"username":"0795386078","password":"123456"},{"username":"0796230212","password":"123456"},{"username":"0766830653","password":"123456"},{"username":"0763852658","password":"123456"},{"username":"0795333877","password":"123456"}]

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users1}
with open("/bloggt/files/km1.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km1.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users2}
with open("/bloggt/files/km2.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km2.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users3}
with open("/bloggt/files/km3.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km3.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users4}
with open("/bloggt/files/km4.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km4.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users5}
with open("/bloggt/files/km5.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km5.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users6}
with open("/bloggt/files/km6.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km6.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users7}
with open("/bloggt/files/km7.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km7.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users8}
with open("/bloggt/files/km8.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km8.json", "w") as text_file: text_file.write(json.dumps(kmObject))

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':58, 'videos': videos, "users":users9}
with open("/bloggt/files/km9.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km9.json", "w") as text_file: text_file.write(json.dumps(kmObject))

EOF
python viewPlus.py
