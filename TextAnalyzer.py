fname = input('Enter Filename: ')
if len(fname) < 1  : fname = 'macbeth.txt'
hand = open(fname)

di = dict()
for lin in hand:
    lin = lin.rstrip()
    wds = lin.split()
    for w in wds:
        # retrieve/create/update counter
        di[w] = di.get(w,0) + 1
#print(di)
# find the most common words
largest = -1
word = None
for k,v in di.items() :
    print(k,v)
    if v > largest :
        largest = v
        word = k #capture/remeber the key that was largest
print('DONE: ',word,largest)
