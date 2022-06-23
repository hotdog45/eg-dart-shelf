# Socket Programming in Python

Sockets and the socket API are used to send messages across a network. They provide a form of inter-process communication (IPC). The network can be a logical, local network to the computer, or one that’s physically connected to an external network, with its own connections to other networks. The obvious example is the Internet, which you connect to via your ISP.

## Requirements

- [Python](https://www.python.org/) 3.6 or later.

## Background
Sockets have a long history. Their use originated with ARPANET in 1971 and later became an API in the Berkeley Software Distribution (BSD) operating system released in 1983 called Berkeley sockets.

When the Internet took off in the 1990s with the World Wide Web, so did network programming. Web servers and browsers weren’t the only applications taking advantage of newly connected networks and using sockets. Client-server applications of all types and sizes came into widespread use.

Today, although the underlying protocols used by the socket API have evolved over the years, and new ones have developed, the low-level API has remained the same.

The most common type of socket applications are client-server applications, where one side acts as the server and waits for connections from clients. This is the type of application that you’ll be creating in this tutorial. More specifically, you’ll focus on the socket API for Internet sockets, sometimes called Berkeley or BSD sockets. There are also Unix domain sockets, which can only be used to communicate between processes on the same host.

## Learn Case

1. Socket API
2. TCP Sockets
3. Echo Client and Server
    - Echo Server
    - Echo Client
    - View Socket State
4. Commuication Breakdown
5. Handling Multiple Connections
6. Multi-Connection Client and Server
    - Multi-Connection Server
    - Multi-Connection Client
7. Application Client and Server
    - Application Protocol Header
    - Sending an Application Message
    - Application Message Class
8. Troubleshooting
    - ping
    - netstat
    - windows
    - wireshark

## Reference

This source code for learning socker programming in Python on [article.](https://realpython.com/python-sockets/#socket-api-overview)

## License

The MIT License. See the file LICENSE in this repository's base directory.
