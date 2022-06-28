cat > viewPlus.py <<EOF
import json

users=[]
for item in ['0769111340','0704913036','0774844168','0772874251','0782905498','0795924365','0705857361','0795386078','0796230212','0793226823','0766409742','0899023764','0766967912','0789696680','0769114174','0766830653','0899277441','0706353580','0898014564','0785134845','0704809647','0796932615','0769106756','0776872754','0793298327','0778407130','0795518449','0931075634','0934674002','0702697565','0763994987','0763852658','0789256576']: users.append({"username":item, "password": "123456"})
videos = []
videos_file = open("videos101.txt", "r").read().split('\n')
videos_file = list(filter(None, videos_file))
for item in videos_file: videos.append({"videoUrl":item})
kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':25, "totalPerDayConfig":30, 'videos': videos, "users":users}
with open("km101.json", "w") as text_file: text_file.write("")
with open("km101.json", "w") as text_file: text_file.write(json.dumps(kmObject,sort_keys = True))

users=[]
for item in ['0782951838','0934963429','0705849181','0778546756','0937296062','0782356153','0901510054','0903074763','0933697511','0799682267','0795437648','0932689962','0796437126','0934697100','0938943825','0903436720','0902473260','0706820252','0797175719','0902851053','0788719784','0906065983','0794199050','0792215341','0795333877','0788255426','0936021460','0787866436','0775448723','0778458912']: users.append({"username":item, "password": "123456"})
videos = []
videos_file = open("videos102.txt", "r").read().split('\n')
videos_file = list(filter(None, videos_file))
for item in videos_file: videos.append({"videoUrl":item})
kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':25, "totalPerDayConfig":30, 'videos': videos, "users":users}
with open("km102.json", "w") as text_file: text_file.write("")
with open("km102.json", "w") as text_file: text_file.write(json.dumps(kmObject,sort_keys = True))

users=[]
for item in ['0901227402','0904771611','0907527714','0708725545','0932672538','0776718354','0776881731','0904766994','0707390669','0797083394','0798718244','0799628842','0706319949','0706306115','0768802337','0766789731','0705590319','0775528911','0788873309','0788929817','0766789723','0779436810','0901573034','0936649217','0904027817','0902737865','0784757980','0793368201','0905769903','0904849837']: users.append({"username":item, "password": "123456"})
videos = []
videos_file = open("videos103.txt", "r").read().split('\n')
videos_file = list(filter(None, videos_file))
for item in videos_file: videos.append({"videoUrl":item})
kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':25, "totalPerDayConfig":30, 'videos': videos, "users":users}
with open("km103.json", "w") as text_file: text_file.write("")
with open("km103.json", "w") as text_file: text_file.write(json.dumps(kmObject,sort_keys = True))

users=[]
for item in ['0772130736','0796861577','0783943688','0794200961','0776345961','0901511418','0904084904','0901719632','0906089621','0702506952','0794290176','0777941627','0774557983','0775497374','0786800294','0898262452','0795810591','0768805966','0796237891','0793363952','0774536430','0899074232','0787834821','0774839883','0792280742','0896734315','0898029760','0793707917','0934497106','0769608169']: users.append({"username":item, "password": "123456"})
videos = []
videos_file = open("videos104.txt", "r").read().split('\n')
videos_file = list(filter(None, videos_file))
for item in videos_file: videos.append({"videoUrl":item})
kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':25, "totalPerDayConfig":30, 'videos': videos, "users":users}
with open("km104.json", "w") as text_file: text_file.write("")
with open("km104.json", "w") as text_file: text_file.write(json.dumps(kmObject,sort_keys = True))

users=[]
for item in ['0777557928','0769161506','0815132642','0702849950','0762833862','0777848056','0778126560','0896042871','0706886782','0767950963','0898825963','0797016130','0793398633','0777512238','0799163670','0899242657','0774517087','0787979985','0898229698','0899026920','0776841510','0783222943','0706772235','0774496259','0775438389','0774467369','0702220145','0774425254','0789072604','0898214830']: users.append({"username":item, "password": "123456"})
videos = []
videos_file = open("videos105.txt", "r").read().split('\n')
videos_file = list(filter(None, videos_file))
for item in videos_file: videos.append({"videoUrl":item})
kmObject = {'timeInterval': [{'from': 35,'to':45}],'timeLoginAgain':25, "totalPerDayConfig":30, 'videos': videos, "users":users}
with open("km105.json", "w") as text_file: text_file.write("")
with open("km105.json", "w") as text_file: text_file.write(json.dumps(kmObject,sort_keys = True))
EOF
python viewPlus.py
