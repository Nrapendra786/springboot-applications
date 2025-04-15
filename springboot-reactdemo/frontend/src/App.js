
import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ClientList from './ClientList';
import ClientEdit from "./ClientEdit";

class App extends Component {
  render() {
    return (
        <Router>
          <Switch>
            <Route path='/' exact={true} component={Home}/>
            <Route path='/clients' exact={true} component={ClientList}/>
            <Route path='/clients/:id' component={ClientEdit}/>
          </Switch>
        </Router>
    )
  }
}
export default App;





















// import React from 'react';
// import logo from './assets/logo.png';

// class App extends React.Component {
//   state = {
//     clients: []
//   };

//   async componentDidMount() {
//     const response = await fetch('http://localhost:8080/clients');
//      const body = await response.json();
//      console.log(body);
//      this.setState({clients: body});
//   }

//   render() {
//     const {clients} = this.state;
//     return (
//         <div className="App">
//           <header className="App-header">
//             {/* <img src={logo} className="App-logo" alt="logo" /> */}
//             <div className="App-intro">
//               <h2>Clients</h2>
//               {clients.map(client =>
//                   <div key={client.id}>
//                     {client.name} ({client.email})
//                   </div>
//               )}
//             </div>
//           </header>
//         </div>
//     );
//   }
// }
// export default App;

