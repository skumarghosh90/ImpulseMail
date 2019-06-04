import React from 'react';
import ReactDOM from 'react-dom';
import {Route, BrowserRouter, withRouter, Redirect, Switch} from 'react-router-dom';
import * as serviceWorker from './serviceWorker';

import App from './App';
import LoginForm from './loginForm';

import 'font-awesome/css/font-awesome.min.css';
import 'bootstrap/dist/css/bootstrap.min.css'; 

function render() {
ReactDOM.render(
    <BrowserRouter>
        <Switch>
            <Route exact path="/login" component={LoginFormWrapper}/>
            <Route exact path="/inbox" render={checkLogin}/>
            <Route exact path="/profile" render={checkLogin}/>
            <Route path="/" render={checkLogin}/>
        </Switch>
    </BrowserRouter>
    , document.getElementById('root'));
}

function resetState() {
    state.searchedMessage = undefined;
    state.loggedInUser = undefined;
    state.searchedPhrase = '';
    state.page = '/inbox';
}

const state = {
    searchedMessage: undefined,
    loggedInUser: undefined,
    searchedPhrase: '',
    page: '/inbox'
}

function handleSearchResult(value) {
    state.searchedMessage = value;
    render();
}

const AppWrapper = withRouter(({history}) => {
        return (<App handleSearchResult={handleSearchResult} state={state} onLogout={() => {console.log('logging out');
                                                                                        resetState();
                                                                                        history.push('/login');
                                                                                    }}/>);    
});

const LoginFormWrapper = withRouter(({history}) => {
    return (<LoginForm handleLogin = {(user) => {
                                state.loggedInUser = user;
                                history.push('/inbox');
                            }}/>);
});

function checkLogin({match}) {
    console.log(match);
    if(!state.loggedInUser || !state.loggedInUser.authToken) {
        console.log('User is not logged in');
        return (<Redirect to="/login" component={LoginFormWrapper} />);
    } else {
        if(match.path === '/') {
            return (<Redirect to="/inbox" component={AppWrapper} />);
        }
        state.page = match.path;
        return (<AppWrapper/>);
    }
}

render();
serviceWorker.unregister();
