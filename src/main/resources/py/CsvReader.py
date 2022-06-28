from matplotlib import pyplot
from collections import Counter
from matplotlib import colors
import csv
import logging as log
log.basicConfig(filename="log.log", level=log.INFO)


# objs = json.loads(
#     '[{"id":7582,"enter_date":"2020-09-21 00:00:00","invitation_num":8782},{"id":7579,"enter_date":"2020-09-21 00:00:00","invitation_num":17150},{"id":7576,"enter_date":"2020-09-21 00:00:00","invitation_num":26055}]'
# )
csvReader = CsvReader("input_dic.csv")
csvReader.drawAmount()

class CsvReader:
    def __init__(self, fileName):
        self.fileName = fileName
        self.lst = []

    def drawDoanhThuTest(self):
        years = [2013, 2014, 2015, 2016, 2017, 2018, 2019, 2020]
        companyA = [1, 2, 3, 4, 5, 6, 7, 8]
        companyB = [10, 20, 30, 40, 50, 60, 70, 80]
        companyB = [12, 22, 32, 42, 52, 62, 72, 82]
        pyplot.xkcd()
        pyplot.style.use('classic')
        pyplot.plot(years,
                    companyA,
                    color='red',
                    linestyle='--',
                    marker='.',
                    markersize=20)
        pyplot.plot(years,
                    companyB,
                    color='green',
                    linestyle='--',
                    marker='.',
                    markersize=20)
        pyplot.bar(years, companyB, color='green')
        pyplot.xlabel("Năm")
        pyplot.ylabel("Lợi nhuận")
        pyplot.legend(["K-media", "Bình Minh", "GoQuo"])
        pyplot.grid(True)
        pyplot.savefig("doanhthu.png")
        pyplot.show()
        print(pyplot.style.available)

    def drawDoanhThu(self):
        enter_dates = [(item['enter_date']) for item in self.lst]
        counters = Counter(enter_dates)
        lstX = []
        lstY = []
        for key in counters.keys():
            lstX.append(key)
            lstY.append(counters.get(key))

        pyplot.barh(lstX, lstY, color='red')
        pyplot.show()

    def readCsv(self):
        with open(self.fileName) as csv_file:
            csv_reader = csv.reader(csv_file)
            self.lst = []
            for row in csv_reader:
                try:
                    self.lst.append({
                        "id": row[0],
                        "enter_date": row[1].split(" ")[0],
                        "number": row[2]
                    })
                except:
                    pass

    def readCsvAsDic(self):
        with open(self.fileName) as csv_file:
            csv_reader = csv.DictReader(csv_file)
            self.lst = []
            for row in csv_reader:
                try:
                    self.lst.__contains__()
                    self.lst.append({
                        "resource_type":
                        row["resource_type"],
                        "enter_date":
                        row["enter_date"].split(" ")[0],
                        "loan_total_amount":
                        row["loan_total_amount"]
                    })
                except:
                    pass

    def drawAmount(self):
        with open(self.fileName) as csv_file:
            csv_reader = csv.DictReader(csv_file)
            lstX = []
            lstY = []
            for row in csv_reader:
                try:
                    enter_date = row["enter_date"]
                    loan_total_amount = row["loan_total_amount"]
                    if not (lstX.__contains__(enter_date)):
                        lstX.append(enter_date)
                        lstY.append(loan_total_amount)
                    else:
                        # lstX.append(enter_date)
                        pass
                except:
                    pass
        pyplot.barh(lstX, lstY, color='red')
        pyplot.show()