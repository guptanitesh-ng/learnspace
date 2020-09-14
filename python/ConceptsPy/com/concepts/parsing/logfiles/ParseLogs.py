import re
from collections import OrderedDict

executionLimit = 100;

def init_report_table():
    return OrderedDict([
            ("Session ID", [])            
        ])
    
if __name__ == "__main__":
    readFile = open("clu-cas-performance-cas8128.log", "r")
    count = 1
    uuidRegex = re.compile(r'([A-Fa-f0-9]{8})-([A-Fa-f0-9]{4})-([A-Fa-f0-9]{4})-([A-Fa-f0-9]{4})-([A-Fa-f0-9]{12})')
    reportTable = init_report_table()
    for line in readFile:
        match = uuidRegex.search(line)
        if match:
            sessionId = match.group(0)
            if sessionId not in reportTable["Session ID"]:
                reportTable["Session ID"].append(match.group(0))
            tokens = line.split(" ")
            start = tokens.index(sessionId)
            classMethodPair = tokens[start+3]
            #print classMethodPair
            if "Dao" in classMethodPair:
                names = classMethodPair.split(".")
                daoClassMethodPair = names[len(names)-2]+"."+names[len(names)-1]
                print daoClassMethodPair
                if daoClassMethodPair not in reportTable:
                    reportTable[daoClassMethodPair] = []
                reportTable[daoClassMethodPair].append(tokens[start+5])
                count = count + 1
        if count > executionLimit:
            break
    readFile.close()
    print reportTable