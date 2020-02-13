title = '\xF0\xA0\xBA\x98\xE5\x8F'
# print(unicode(title,'utf-8'))
print(str(title))
# print(title.decode('utf-8'))
s_title = title.encode('raw_unicode_escape')
ss_title = s_title.decode()
print(ss_title)
