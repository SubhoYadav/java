const http = require('http')

const handlerFunction = (request, response) => {
  const quotes = [
    'Keep Coding',
    'keep Learning',
    'Keep Exercising' 
  ]

  switch(request.url) {
    case '/get_quote':
      const quoteIndex = Math.floor(Math.random() * ((quotes.length - 1) - 0 + 1) + 0)
      if (quoteIndex >= 0 && quoteIndex <= quotes.length - 1) {
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.write(quotes[quoteIndex]);
        response.end()
      }
      else {
        response.writeHead(200, {'Content-Type': 'text/html'});
        response.write(quotes[0]);
        response.end()
      }      
    break;
    default:
      response.writeHead(200, {'Content-Type': 'text/html'});
      response.write('No routes to serve requests');
      response.end()

  }
  
}
const port = 7000
const server = http.createServer(handlerFunction).listen(port, ()=> {
  console.log(`Server started on: port: ${port}`)
});