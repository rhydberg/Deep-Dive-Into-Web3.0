import string
import hashlib
import time


def mine(a: string):
    i = 0
    target = 0x00000FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF
    while True:
        i = i + 1
        b = a + str(i)

        if int(hashlib.sha256(b.encode('utf-8')).hexdigest(), 16) < target:
            break

    return i


s = input("Enter String")
start = time.time()
print("Nonce: "+ str(mine(s)))
end = time.time()
print("Execution Time: " + str(end-start))
