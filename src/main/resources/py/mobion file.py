import json

videos = []
videos_file = open("videos10.txt", "r").read().split('\n')
videos_file = list(filter(None, videos_file))
for item in videos_file: videos.append({"videoUrl":item})

users=[]
users_file = open("sims1.txt", "r").read().split('\n')
users_file = list(filter(None, users_file))
for item in users_file: users.append({"username":item, "password": "123456"})

kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':25, 'videos': videos, "users":users}
with open("/bloggt/files/km.json", "w") as text_file: text_file.write("")
with open("/bloggt/files/km.json", "w") as text_file: text_file.write(json.dumps(kmObject))