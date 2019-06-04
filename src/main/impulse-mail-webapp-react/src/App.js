import React from 'react';
import TopNavbar from './topNavBar';
import LeftNavPanel from './leftNavPanel';


function App(props) {
    return (
      <div className="container-fluid" style={{backgroundColor : '#003e66', height: '100vh'}}>      
        <TopNavbar {...props}/>
        <div className="row" style={{paddingLeft: '0px', marginTop: '10px', height: '90vh'}}>
          <div className="col-md-2"  style={{marginLeft: '0px'}}>
             <LeftNavPanel/>
          </div>
          <div className="col-md-5" style={{backgroundColor : '#93d697',  height: '90vh'}}>
              {props.state.searchedMessage ? JSON.stringify(props.state.searchedMessage) : 'No Messages'}
          </div>
          <div className="col-md-4" style={{backgroundColor : '#dcf3f4',  height: '90vh', marginLeft: '10px'}}/>
        </div>
      </div>
    ); 
}

export default App;
