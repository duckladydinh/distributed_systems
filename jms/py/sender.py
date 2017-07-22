import time
import stomp


class MyListener(stomp.ConnectionListener):
    def __init__(self, conn):
        self.conn = conn

    def on_message(self, headers, message):
        print('Received a message "%s"' % message)


def connect_and_subscribe(conn, queue, id):
    conn.start()
    conn.connect()
    conn.subscribe('/queue/' + queue, id)

conn = stomp.Connection([('0.0.0.0', 61613)])
connect_and_subscribe(conn, 'qONE', 1)

spy = stomp.Connection([('0.0.0.0', 61613)])
spy.set_listener('', MyListener(spy))
connect_and_subscribe(spy, 'qTWO', 2)

while True:
    line = input()
    if line == 'BYE':
        break
    conn.send('/queue/qONE', line)
    conn.send('/queue/qONE', line)


time.sleep(1)
conn.disconnect()
conn.stop()